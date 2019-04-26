package com.company;

import java.util.EventListener;

// Roughly analogous to .NET delegate
interface IStudentReferenceHandler extends EventListener {
    void StudentReferenceChanged(StudentListHandlerEventArgs args);
}