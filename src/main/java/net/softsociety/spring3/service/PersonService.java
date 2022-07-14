package net.softsociety.spring3.service;

import java.util.ArrayList;

import net.softsociety.spring3.vo.Person;

//서비스 인터페이스
public interface PersonService {
	//저장
	public int insertPerson(Person person);

	public int deletePerson(String name);

	public ArrayList<Person> selectPerson();
}
