package com.poly.api.service.serviceImpl;

import com.poly.api.dto.StudentDto;
import com.poly.api.dto.UserDto;
import com.poly.api.entities.*;
import com.poly.api.repository.*;
import com.poly.api.service.StudentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private NationRepository nationRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private TrainingsystemRepository trainingsystemRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SpecializedRepository specializedRepository;


    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepository.findAll();
        return findAllById(students);
    }

    @Override
    public StudentDto findById(int studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentDto studentDto = modelMapper.map(new StudentDto(
                student.getStudentId(),
                student.getName(),
                student.getBirthday(),
                student.getSex(),
                student.getNation().getNationId(),
                student.getIdentityId(),
                student.getDateCreate(),
                student.getIssuedBy(),
                student.getSchool().getSchoolId(),
                student.getGraduating(),
                student.getGraduatingDate(),
                student.getSpecialized().getSpecializedId(),
                student.getFacility().getFacilityId(),
                student.getEmail(),
                student.getAddress(),
                student.getPostalAddress(),
                student.getParentsName(),
                student.getParentsPhoneNumberTow(),
                student.getStudentPhoneNumberOne(),
                student.getStudentPhoneNumberTow(),
                student.getParentsPhoneNumberOne(),
                student.getCountry(),
                student.getDistrict().getDistrictId(),
                student.getProvince().getProvinceId(),
                student.getTrainingsystem().getTrainingSystemId(),
                student.getFolderId(),
                student.getNameImageCardIdOne(),
                student.getNameImageCardIdTow(),
                student.getNameImageCertificateOfGraduation(),
                student.getNameImageCertificate(),
                student.getNameImagebirthCertificate(),
                student.getNameImageRegistrationForm()
        ), StudentDto.class);
        return studentDto;
    }

    @Override
    public List<StudentDto> findAllByNationId(int nationId) {
        List<Student> students = studentRepository.findAllByNationId(nationId);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllByProvinceId(int provinceId) {
        List<Student> students = studentRepository.findAllByProvinceId(provinceId);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllByDistrictId(int districtId) {
        List<Student> students = studentRepository.findAllByDistrictId(districtId);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllByTrainingSystemId(int trainingSystem) {
        List<Student> students = studentRepository.findAllByTrainingSystemId(trainingSystem);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllByFacilityId(int facilityId) {
        List<Student> students = studentRepository.findAllByFacilityId(facilityId);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllBySchoolId(int schoolId) {
        List<Student> students = studentRepository.findAllBySchoolId(schoolId);
        return findAllById(students);
    }

    @Override
    public List<StudentDto> findAllBySpecializedId(int specializedId) {
        List<Student> students = studentRepository.findAllBySpecializedId(specializedId);
        return findAllById(students);
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = convertStudentWithDto(studentDto);
        studentRepository.save(student);
        return studentDto;
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        Student student = convertStudentWithDto(studentDto);
        studentRepository.save(student);
        return studentDto;
    }

    public List<StudentDto> findAllById(List<Student> students) {
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add
                    (new StudentDto(
                            student.getStudentId(),
                            student.getName(),
                            student.getBirthday(),
                            student.getSex(),
                            student.getNation().getNationId(),
                            student.getIdentityId(),
                            student.getDateCreate(),
                            student.getIssuedBy(),
                            student.getSchool().getSchoolId(),
                            student.getGraduating(),
                            student.getGraduatingDate(),
                            student.getSpecialized().getSpecializedId(),
                            student.getFacility().getFacilityId(),
                            student.getEmail(),
                            student.getAddress(),
                            student.getPostalAddress(),
                            student.getParentsName(),
                            student.getParentsPhoneNumberTow(),
                            student.getStudentPhoneNumberOne(),
                            student.getStudentPhoneNumberTow(),
                            student.getParentsPhoneNumberOne(),
                            student.getCountry(),
                            student.getDistrict().getDistrictId(),
                            student.getProvince().getProvinceId(),
                            student.getTrainingsystem().getTrainingSystemId(),
                            student.getFolderId(),
                            student.getNameImageCardIdOne(),
                            student.getNameImageCardIdTow(),
                            student.getNameImageCertificateOfGraduation(),
                            student.getNameImageCertificate(),
                            student.getNameImagebirthCertificate(),
                            student.getNameImageRegistrationForm()));
        }
        Type listType = new TypeToken<List<StudentDto>>() {}.getType();
        List<StudentDto> dtoList = modelMapper.map(studentDtos, listType);
        return dtoList;
    }

    public Student convertStudentWithDto(StudentDto studentDto) {

        Nation nation = nationRepository.findById(studentDto.getNationId()).get();
        School school = schoolRepository.findById(studentDto.getSchoolId()).get();
        Specialized specialized = specializedRepository.findById(studentDto.getSpecializedId()).get();
        Facility facility = facilityRepository.findById(studentDto.getFacilityId()).get();
        District district = districtRepository.findById(studentDto.getDistrictId()).get();
        Province province = provinceRepository.findById(studentDto.getProvinceId()).get();
        Trainingsystem trainingsystem = trainingsystemRepository.findById(studentDto.getTrainingsystemId()).get();

        Student student = modelMapper.map(new Student(
                studentDto.getStudentId(),
                studentDto.getName(),
                studentDto.getBirthday(),
                studentDto.getSex(),
                nation,
                studentDto.getIdentityId(),
                studentDto.getDateCreate(),
                studentDto.getIssuedBy(),
                school,
                studentDto.getGraduating(),
                studentDto.getGraduatingDate(),
                specialized,
                facility,
                studentDto.getEmail(),
                studentDto.getAddress(),
                studentDto.getPostalAddress(),
                studentDto.getParentsName(),
                studentDto.getParentsPhoneNumberTow(),
                studentDto.getStudentPhoneNumberOne(),
                studentDto.getStudentPhoneNumberTow(),
                studentDto.getParentsPhoneNumberOne(),
                studentDto.getCountry(),
                district,
                province,
                trainingsystem,
                studentDto.getFolderId(),
                studentDto.getNameImageCardIdOne(),
                studentDto.getNameImageCardIdTow(),
                studentDto.getNameImageCertificateOfGraduation(),
                studentDto.getNameImageCertificate(),
                studentDto.getNameImagebirthCertificate(),
                studentDto.getNameImageRegistrationForm()
        ), Student.class);
        return student;
    }
}
