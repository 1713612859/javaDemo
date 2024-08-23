package com.test.convert;

import com.alibaba.fastjson2.JSON;
import com.test.domain.Student;
import com.test.domain.StudentVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.io.IOException;

/**
 * @Desc StudentMapper
 * @Author LiuYunLong
 */

@Mapper
public interface StudentMapper {


	 StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);


	 @Mapping(source = "name", target = "studentName")
	 @Mapping(source = "gender", target = "stuGender")
	 @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
	 public StudentVo studentToStudentVO(Student student);


	 public static void main(String[] args) throws IOException {

		  var student = new Student();
		  student.setName("LiuYunLong");
		  student.setAge(25);
		  student.setGender("Male");
		  student.setId(Integer.MAX_VALUE);
		  student.setBirthday("2000-01-01");

		  StudentVo studentVo = StudentMapper.INSTANCE.studentToStudentVO(student);
		  System.out.println("studentVo = " + studentVo); //studentVo = StudentVo{id=1, studentName='LiuYunLong', age=25, gender='Male'}

		  System.out.println("JSON.toJSONString(studentVo) = " + JSON.toJSONString(studentVo));
	 }
}
