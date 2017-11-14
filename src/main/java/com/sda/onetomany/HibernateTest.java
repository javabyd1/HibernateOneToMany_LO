package com.sda.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {

		// tworzymy dwoch uzytkownikow
		UserDetails user1 = new UserDetails();
		user1.setUserName("lukasz");

		UserDetails user2 = new UserDetails();
		user2.setUserName("olaf");

		//tworzymy dwa pojazdy
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Bike");


		//tworzenie sesji jest w main, troche nie ładnie to wygląda
		//warto ten kod poprawic tak aby konfiguracje hibernate wyniesc do osobnej klasy
		//zrobic klase dao, ktore bedzie wykonywac okreslone operacje na bazie danych
		//tak jak robilismy to z uzytkownikami ostatnio
		//kod podzielic na paczki
		//*napisac testy
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);

		// przypisujemy pojazd do uzytkownika
		vehicle1.setUserDetails(user1);
		vehicle2.setUserDetails(user2);
		// dodajemy
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();

		//program sie nie zamyka - poprawic
	}
}
