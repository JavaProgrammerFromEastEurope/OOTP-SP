package com.company;

import java.util.EventListener;

// Roughly analogous to .NET delegate
interface IStudentCountHandler extends EventListener {
    void StudentsCountChanged(StudentListHandlerEventArgs args);
}