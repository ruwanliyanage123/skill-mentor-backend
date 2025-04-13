package com.skillmentor.core.service;

import com.skillmentor.core.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private List<StudentDTO> studentDTOS = new ArrayList<>();

    public StudentServiceImpl() {
        studentDTOS.add(new StudentDTO(1, "Ruwan", "Silva", "ruwan.s@example.com", "0771111001", "Colombo 07", 22));
        studentDTOS.add(new StudentDTO(2, "Nadun", "Perera", "nadun.p@example.com", "0771111002", "Colombo 07", 22));
        studentDTOS.add(new StudentDTO(3, "Sahan", "Fernando", "sahan.f@example.com", "0771111003", "Kandy", 23));
        studentDTOS.add(new StudentDTO(4, "Tharindu", "Karunaratne", "tharindu.k@example.com", "0771111004", "Kandy", 23));
        studentDTOS.add(new StudentDTO(5, "Chamika", "Rajapaksha", "chamika.r@example.com", "0771111005", "Matara", 24));
        studentDTOS.add(new StudentDTO(6, "Isuru", "Madushan", "isuru.m@example.com", "0771111006", "Matara", 24));
        studentDTOS.add(new StudentDTO(7, "Kasun", "Bandara", "kasun.b@example.com", "0771111007", "Galle", 25));
        studentDTOS.add(new StudentDTO(8, "Harsha", "Wijesinghe", "harsha.w@example.com", "0771111008", "Galle", 25));
        studentDTOS.add(new StudentDTO(9, "Dinesh", "Kumara", "dinesh.k@example.com", "0771111009", "Galle", 22));
        studentDTOS.add(new StudentDTO(10, "Dilshan", "Amarasinghe", "dilshan.a@example.com", "0771111010", "Colombo 07", 22));
        studentDTOS.add(new StudentDTO(11, "Thisara", "Perera", "thisara.p@example.com", "0771111011", "Matara", 23));
        studentDTOS.add(new StudentDTO(12, "Lahiru", "Sandaruwan", "lahiru.s@example.com", "0771111012", "Kandy", 23));
        studentDTOS.add(new StudentDTO(13, "Manoj", "Jayasuriya", "manoj.j@example.com", "0771111013", "Kandy", 23));
        studentDTOS.add(new StudentDTO(14, "Pasindu", "Dissanayake", "pasindu.d@example.com", "0771111014", "Colombo 07", 21));
        studentDTOS.add(new StudentDTO(15, "Nimal", "Edirisinghe", "nimal.e@example.com", "0771111015", "Colombo 07", 21));
        studentDTOS.add(new StudentDTO(16, "Upul", "Pathirana", "upul.p@example.com", "0771111016", "Matara", 24));
        studentDTOS.add(new StudentDTO(17, "Sadeepa", "Samarakoon", "sadeepa.s@example.com", "0771111017", "Galle", 25));
        studentDTOS.add(new StudentDTO(18, "Heshan", "Wijeratne", "heshan.w@example.com", "0771111018", "Colombo 07", 22));
        studentDTOS.add(new StudentDTO(19, "Ravindu", "Lakmal", "ravindu.l@example.com", "0771111019", "Matara", 24));
        studentDTOS.add(new StudentDTO(20, "Akila", "Jayasinghe", "akila.j@example.com", "0771111020", "Colombo 07", 22));
    }

    @Override
    public List<StudentDTO> getAllStudents(List<String> firstNames, List<String> lastNames, List<String> emails, List<String> phoneNumbers, List<Integer> ages) {
        return studentDTOS.stream()
                .filter(stu -> firstNames == null || firstNames.isEmpty() || firstNames.contains(stu.getFirstName()))
                .filter(stu -> lastNames == null || lastNames.isEmpty() || lastNames.contains(stu.getLastName()))
                .filter(stu -> emails == null || emails.isEmpty() || emails.contains(stu.getEmail()))
                .filter(stu -> phoneNumbers == null || phoneNumbers.isEmpty() || phoneNumbers.contains(stu.getPhoneNumber()))
                .filter(stu -> ages == null || ages.isEmpty() || ages.contains(stu.getAge()))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
        final Optional<StudentDTO> studentDTOOptional = studentDTOS.stream().filter(stu -> stu.getStudentId().equals(studentId)).findFirst();
        return studentDTOOptional.orElse(null);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        studentDTOS.add(studentDTO);
        return studentDTO;
    }

    public StudentDTO updateStudent(StudentDTO studentDTO){
        final StudentDTO prevStudent = studentDTOS.get(studentDTO.getStudentId());
        prevStudent.setAddress(studentDTO.getAddress());
        prevStudent.setAge(studentDTO.getAge());
        prevStudent.setEmail(studentDTO.getEmail());
        prevStudent.setFirstName(studentDTO.getFirstName());
        prevStudent.setLastName(studentDTO.getLastName());
        prevStudent.setPhoneNumber(studentDTO.getPhoneNumber());
        studentDTOS.add(studentDTO.getStudentId(), prevStudent);
        return studentDTO;
    }
}
