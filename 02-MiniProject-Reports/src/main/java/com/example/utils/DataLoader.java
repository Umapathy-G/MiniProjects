package com.example.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.entities.UserReport;
import com.example.repo.UserReportRepo;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	UserReportRepo userReportRepo;

	@Override
	public void run(String... args) throws Exception {
		List<UserReport> userList = new ArrayList<>();

		String[] name = { "Raja", "Ramu", "Vijay", "Babu", "kamal", "Somu", "Vishnu", "Saran", "Kalai", "Nithish",
				"Sam", "Arun", "Balu", "Mani", "Chandru", "Anitha", "Vani", "Rani", "Renu", "Uma" };
		String[] gender = { "M", "M", "M", "M", "M", "M", "M", "M", "M", "M", "M", "M", "M", "M", "M", "F", "F", "F",
				"F", "F" };
		String[] planname = { "Cash", "Cash", "Cash", "Cash", "Cash", "Food", "Food", "Food", "Food", "Food", "Medical",
				"Medical", "Medical", "Medical", "Medical", "Employment", "Employment", "Employment", "Employment",
				"Employment" };
		String[] planstatus = { "Approved", "Approved", "Approved", "Approved", "Approved", "Approved", "Approved",
				"Denied", "Denied", "Denied", "Denied", "Denied", "Denied", "Denied", "Terminated", "Terminated",
				"Terminated", "Terminated", "Terminated", "Terminated" };

		String[] startdate = { "2016-01-01", "2017-02-01", "2018-03-01", "2019-04-01", "2020-05-01", "2021-06-01",
				"2022-07-01", "2023-08-01", "2023-09-01", "2022-10-01", "2022-11-01", "2022-12-01", "2023-01-01",
				"2023-02-01", "2023-03-01", "2023-04-01", "2023-05-01", "2023-06-01", "2023-03-01", "2023-04-01" };

		String[] enddate = { "2021-01-01", "2022-02-01", "2023-03-01", "2024-04-01", "2024-05-01", "2026-06-01",
				"2027-07-01", "2028-08-01", "2028-09-01", "2027-10-01", "2027-11-01", "2027-12-01", "2028-01-01",
				"2028-02-01", "2028-03-01", "2028-04-01", "2028-05-01", "2028-06-01", "2028-03-01", "2028-04-01" };

		for (int i = 0; i < 20; i++) {
			userList.add(
					new UserReport(name[i], name[i].toLowerCase() + "@gmail.com", (long) 8552, gender[i], (long) 1234,
							planname[i], planstatus[i], LocalDate.parse(startdate[i]), LocalDate.parse(enddate[i])));

		}

		System.out.println("UserList added");
		userReportRepo.saveAll(userList);

	}

}
