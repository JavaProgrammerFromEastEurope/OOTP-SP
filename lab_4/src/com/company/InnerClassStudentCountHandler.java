package com.company;

  class InnerClassStudentCountHandler extends Journal implements IStudentCountHandler {

    @Override
    public void StudentsCountChanged(StudentListHandlerEventArgs args) {
        studentsCountChanged(new JournalEntry(args));
    }
}


