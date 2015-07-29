package shadow.doctool.output;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import shadow.doctool.DocumentationException;
import shadow.doctool.DocumentationTool;
import shadow.parser.javacc.ShadowException;
import shadow.typecheck.Package;
import shadow.typecheck.type.Type;

/** 
 * A documentation template which generates HTML pages describing packages,
 * classes, and interfaces. This class is the stock template intended to ship
 * with Shadox.
 * 
 * @author Brian Stottler
 */
public class StandardTemplate implements DocumentationTemplate
{
	private static final String CSS_FILE = "stylesheet.css";
	
	private final OverviewPage overviewPage;
	private final Map<Package, PackagePage> packagePages;
	private final Map<Type, ClassOrInterfacePage> typePages;
	
	public static final String docTitle = "Test Documentation";
	public final String timestamp;
	
	public StandardTemplate(Set<Type> typesToDocument, Set<Package> packagesToDocument) 
			throws DocumentationException
	{
		timestamp = new SimpleDateFormat("MMM dd, yyyy 'at' HH:mm:ss z").format(new Date());
		
		overviewPage = new OverviewPage(this, packagesToDocument);
		packagePages = new HashMap<Package, PackagePage>();
		typePages = new HashMap<Type, ClassOrInterfacePage>();
		
		for (Package current : packagesToDocument) {
			PackagePage page = new PackagePage(this, current, 
					packagesToDocument, typesToDocument);
			packagePages.put(current, page);
		}
		
		for (Type current : typesToDocument) {
			ClassOrInterfacePage page = new ClassOrInterfacePage(this, current, 
					typesToDocument);
			typePages.put(current, page);
		}
	}
	
	public void write(Path outputDirectory) 
			throws IOException, ShadowException, DocumentationException
	{
		overviewPage.write(outputDirectory);
		
		for (PackagePage page : packagePages.values())
			page.write(outputDirectory);
		
		for (ClassOrInterfacePage page : typePages.values())
			page.write(outputDirectory);
		
		// Export the style-sheet
		exportResource(outputDirectory.resolve("stylesheet.css"), 
				"/doctool/stylesheet.css");
	}
	
	public PackagePage getPackagePage(Package given)
	{
		return packagePages.get(given);
	}
	
	public OverviewPage getOverviewPage()
	{
		return overviewPage;
	}
	
	public ClassOrInterfacePage getTypePage(Type type)
	{
		return typePages.get(type);
	}
	
	/** Creates a relative path from one Page to another */
	public static Path linkToPage(Page from, Page to)
	{
		Path toPath = Paths.get("/").resolve(to.getRelativePath());
		
		// For some reason, Path.relativize() will only work from the directory
		// above the start file
		Path fromPath = from.getRelativePath().getParent();
		if (fromPath == null)
			fromPath = Paths.get("/");
		else
			fromPath = Paths.get("/").resolve(fromPath);
		
		return fromPath.relativize(toPath);
	}
	
	/** Creates a relative link to the master stylesheet */
	public static Path linkToCss(Page from)
	{
		Path toPath = Paths.get(File.separator + CSS_FILE);
		
		// For some reason, Path.relativize() will only work from the directory
		// above the start file
		Path fromPath = from.getRelativePath().getParent();
		if (fromPath == null)
			fromPath = Paths.get("/");
		else
			fromPath = Paths.get("/").resolve(fromPath);
		
		return fromPath.relativize(toPath);
	}
	
	private static void exportResource(Path targetFile, String resource) throws DocumentationException, IOException
	{
		InputStream input = DocumentationTool.class.getResourceAsStream(resource);
		if (input == null)
			throw new DocumentationException("Could not load \"" + resource 
					+ "\" from JAR");
		
		Files.deleteIfExists(targetFile);
		Files.copy(input, targetFile);
	}
	
	// TODO: Include the compiler version (no current mechanism)
	public void writeTimestampComment(HtmlWriter out) 
			throws DocumentationException, ShadowException
	{
		out.commentLine("Generated by Shadox on " + timestamp);
	}
}
