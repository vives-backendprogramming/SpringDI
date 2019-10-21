package be.vives.ti.service;

import be.vives.ti.model.Student;
import be.vives.ti.model.Teacher;

public interface IEmailService {
    void sendEmail(Teacher teacher, String message, Student student);
}
