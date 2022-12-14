package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> result = Optional.empty();
        for (Student student : students.keySet()) {
            if (account.equals(student.getAccount())) {
                result = Optional.of(student);
                break;
            }
        }
        return result;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> result = Optional.empty();
        Optional<Student> student = findByAccount(account);
        if (student.isPresent()) {
            for (var subject : students.get(student.get())) {
                if (name.equals(subject.nameSub())) {
                    result = Optional.of(subject);
                    break;
                }
            }
        }
        return result;
    }
}
