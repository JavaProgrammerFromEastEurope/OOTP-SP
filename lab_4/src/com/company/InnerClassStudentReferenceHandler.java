package com.company;

 class InnerClassStudentReferenceHandler extends Journal implements IStudentReferenceHandler {

    @Override
    public void StudentReferenceChanged(StudentListHandlerEventArgs args) {
        studentReferenceChanged(new JournalEntry(args));
    }
}
