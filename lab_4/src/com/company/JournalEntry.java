package com.company;

public class JournalEntry {

    private String nameOfCollection;
    private String typeChangesOfCollection;
    private Student changedStudent;

    public JournalEntry(StudentListHandlerEventArgs handlerEventArgs) {

        this.nameOfCollection        = handlerEventArgs.getNameOfCollection();
        this.typeChangesOfCollection = handlerEventArgs.getTypeChangesOfCollection();
        this.changedStudent          = handlerEventArgs.getChangedStudent();
    }

    @Override
    public String toString() {
        return String.format(" Название коллекции = '%s', тип коллекции = '%s', измененный объект = %s}",
                nameOfCollection, typeChangesOfCollection, changedStudent);
    }
}

