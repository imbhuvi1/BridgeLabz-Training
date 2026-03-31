package scenario_based;

import java.util.*;
public class StreamBuzz {
	public static List<CreatorStats> engagementBoard = new ArrayList<CreatorStats>();

	public void registerCreator(CreatorStats record) {
		CreatorStats.engagementBoard.add(record);
		System.out.println("Creator registered successfully\n");
	}

	public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {
		Map<String, Integer> topCreators = new LinkedHashMap<String, Integer>();
		for (CreatorStats creator : records) {
			int count = 0;
			for (double likes : creator.weeklyLikes) {
				if (likes >= likeThreshold) {
					count++;
				}
			}
			if (count > 0) {
				topCreators.put(creator.creatorName, count);
			}
		}
		return topCreators;
	}

	public double calculateAverageLikes() {
		double totalLikes = 0;
		int totalWeeks = 0;
		for (CreatorStats creator : CreatorStats.engagementBoard) {
			for (double likes : creator.weeklyLikes) {
				totalLikes += likes;
				totalWeeks++;
			}
		}
		return totalWeeks != 0 ? totalLikes / totalWeeks : 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StreamBuzz program = new StreamBuzz();
		boolean exit = false;
		while (true) {
			if (exit) {
				break;
			}
			System.out.println("1. Register Creator");
			System.out.println("2. Show Top Posts");
			System.out.println("3. Calculate Average Likes");
			System.out.println("4. Exit");
			System.out.print("Enter your choice:");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1 -> {
				System.out.print("Enter Creator Name:");
				String name = sc.nextLine();
				double[] likes = new double[4];
				System.out.println("Enter weekly likes (Week 1 to 4):");
				for (int i = 0; i < 4; i++) {
					likes[i] = sc.nextDouble();
				}
				sc.nextLine();
				program.registerCreator(new CreatorStats(name, likes));
			}
			case 2 -> {
				System.out.print("Enter like threshold:\n");
				double threshold = sc.nextDouble();
				sc.nextLine();
				Map<String, Integer> topPosts = program.getTopPostCounts(CreatorStats.engagementBoard, threshold);
				if (topPosts.isEmpty()) {
					System.out.println("No top-performing posts this week");
				} else {
					for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
						System.out.println(entry.getKey() + " - " + entry.getValue());
					}
				}
			}
			case 3 -> {
				double avgerageLikes = program.calculateAverageLikes();
				System.out.println("Overall average weekly likes: " + (int) avgerageLikes);
			}

			case 4 -> {
				System.out.println("Logging off - Keep Creating with StreamBuzz!");
				exit = true;
			}
			default -> {
				System.out.println("Invalid choice. Try again!");
			}
			}
		}
	}
}

class CreatorStats {
	public String creatorName;
	public double weeklyLikes[];

	public CreatorStats() {
		// TODO Auto-generated constructor stub
		this.creatorName = null;
		this.weeklyLikes = new double[7];
	}

	public CreatorStats(String creatorName, double[] weeklyLikes) {
		this.creatorName = creatorName;
		this.weeklyLikes = weeklyLikes;
	}

	public static List<CreatorStats> engagementBoard = new ArrayList<>();
}
