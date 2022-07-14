package net.softsociety.spring3.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring3.vo.Person;

@Mapper
public interface PersonDAO {
	
	public int insertPerson(Person person);
	
	public int deletePerson(String name);

	public ArrayList<Person> selectPerson();
}
