; shadow.standard@Class native methods

%_Pshadow_Pstandard_CObject = type opaque
%_Pshadow_Pstandard_CClass_Mclass = type opaque
%_Pshadow_Pstandard_CClass = type { %_Pshadow_Pstandard_CClass_Mclass*, { %_Pshadow_Pstandard_CInterface**, [1 x i32] }, %_Pshadow_Pstandard_CString*, %_Pshadow_Pstandard_CClass*, i32, i32 }
%_Pshadow_Pstandard_CInterface = type opaque
%_Pshadow_Pstandard_CString = type opaque

declare noalias i8* @malloc(i32) nounwind

define noalias %_Pshadow_Pstandard_CObject* @_Pshadow_Pstandard_CClass_McreateObject(%_Pshadow_Pstandard_CClass*) {
	%2 = getelementptr inbounds %_Pshadow_Pstandard_CClass* %0, i32 0, i32 4
	%3 = load i32* %2
	%4 = call noalias i8* @malloc(i32 %3) nounwind
	%5 = bitcast i8* %4 to %_Pshadow_Pstandard_CObject*
	ret %_Pshadow_Pstandard_CObject* %5
}
