package in.ineuron;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.MarriageSeeker;
import in.ineuron.service.IMatrimonyMgmtService;

@SpringBootApplication
public class Boot13DaoProjSpringDataJpa01Application {

	public static void main(String[] args) throws IOException {
		ApplicationContext applicationContext = SpringApplication.run(Boot13DaoProjSpringDataJpa01Application.class,
				args);

		IMatrimonyMgmtService matrimonyMgmtService = applicationContext.getBean(IMatrimonyMgmtService.class);

		Scanner scan = new Scanner(System.in);
		System.out.println("Press 1 for insert operation\n Press 2 for search operation");
		int option = scan.nextInt();

		if (1 == option) {
			MarriageSeeker marriageSeeker = insert();
			String registerStatus = matrimonyMgmtService.registerMarriageSeeker(marriageSeeker);
			System.out.println(registerStatus);

			System.out.println("*******************************************************************************");

		} else if (2 == option) {
			Optional<MarriageSeeker> optional = matrimonyMgmtService.searchMarriageSeekerById(1L);
			if (optional.isPresent()) {
				MarriageSeeker marriageSeekerById = optional.get();
				System.out.println("Marriage Seeker id: " + marriageSeekerById.getId());
				System.out.println("Marriage Seeker name: " + marriageSeekerById.getName());
				System.out.println("Marriage Seeker address: " + marriageSeekerById.getAddress());
				System.out.println("Is Marriage Seeker Bangladeshi?: " + marriageSeekerById.getBangladeshi());

				// to retrieve image
				FileOutputStream fileOutputStream = new FileOutputStream("retrieve_image.jpeg");
				fileOutputStream.write(marriageSeekerById.getPhoto());
				fileOutputStream.flush();

				// to retrieve txt file
				FileWriter fileWriter = new FileWriter("retrieve_biodata.txt");
				fileWriter.write(marriageSeekerById.getBioData());
				fileWriter.flush();

				System.out.println("Both photo and bio-data is retrieved...");

				fileOutputStream.close();
				fileWriter.close();
			} else {
				System.out.println("Record not available");
			}
		}

		scan.close();
		((ConfigurableApplicationContext) applicationContext).close();
	}

	public static MarriageSeeker insert() throws IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter name: ");
		String name = scanner.next();

		System.out.print("Enter address: ");
		String address = scanner.next();

		System.out.print("Enter photo path: ");
		String photoPath = scanner.next();

		System.out.print("Enter bio data path: ");
		String bioDatapath = scanner.next();

		System.out.print("Is the person bangladeshi: ");
		boolean isBangladeshi = scanner.nextBoolean();

		// photo path to make photo data
		FileInputStream fileInputStream = new FileInputStream(photoPath);
		byte[] photoData = new byte[fileInputStream.available()];
		fileInputStream.read(photoData);

		// bioData path to make bio data
		File file = new File(bioDatapath);
		FileReader fileReader = new FileReader(file);
		char[] bioData = new char[(int) file.length()];
		fileReader.read(bioData);

		// creating object of marriage seeker
		MarriageSeeker marriageSeeker = new MarriageSeeker(name, address, photoData,
				LocalDateTime.of(1997, 03, 8, 10, 45), bioData, isBangladeshi);

		fileInputStream.close();
		fileReader.close();
		scanner.close();

		return marriageSeeker;
	}

}
