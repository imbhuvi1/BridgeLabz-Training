package scenario_based;

import java.util.*;

//🔹 Custom Exception
class InvalidBackupPathException extends Exception {
	public InvalidBackupPathException(String message) {
		super(message);
	}
}

//🔹 BackupTask Class
class BackupTask implements Comparable<BackupTask> {
	private String folderPath;
	private int priority; // Higher number = higher priority
	private String scheduledTime;

	public BackupTask(String folderPath, int priority, String scheduledTime) throws InvalidBackupPathException {

		if (folderPath == null || folderPath.trim().isEmpty()) {
			throw new InvalidBackupPathException("Backup path cannot be empty!");
		}

		this.folderPath = folderPath;
		this.priority = priority;
		this.scheduledTime = scheduledTime;
	}

	public String getFolderPath() {
		return folderPath;
	}

	public int getPriority() {
		return priority;
	}

	public String getScheduledTime() {
		return scheduledTime;
	}

	// Higher priority tasks should come first in PriorityQueue
	@Override
	public int compareTo(BackupTask other) {
		return Integer.compare(other.priority, this.priority);
	}

	@Override
	public String toString() {
		return "Folder: " + folderPath + " | Priority: " + priority + " | Time: " + scheduledTime;
	}
}

//🔹 Backup Scheduler System
class BackupScheduler {
	private PriorityQueue<BackupTask> taskQueue = new PriorityQueue<>();

	public void scheduleBackup(String path, int priority, String time) {
		try {
			BackupTask task = new BackupTask(path, priority, time);
			taskQueue.add(task);
			System.out.println("✅ Backup scheduled: " + path);
		} catch (InvalidBackupPathException e) {
			System.out.println("⚠ " + e.getMessage());
		}
	}

	public void executeBackups() {
		if (taskQueue.isEmpty()) {
			System.out.println("No backup tasks scheduled.");
			return;
		}

		System.out.println("\n🔄 Executing backups by priority...\n");

		while (!taskQueue.isEmpty()) {
			BackupTask task = taskQueue.poll(); // removes highest priority
			System.out.println("Backing up: " + task);
			// Here you could add real backup logic
		}
	}
}

//Main Class
public class FileBackupScheduler {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BackupScheduler scheduler = new BackupScheduler();

		while (true) {
			System.out.println("\n=== File Backup Scheduler ===");
			System.out.println("1. Schedule Backup");
			System.out.println("2. Execute All Backups");
			System.out.println("3. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) {
			case 1:
				System.out.print("Enter folder path: ");
				String path = sc.nextLine();

				System.out.print("Enter priority (Higher number = more critical): ");
				int priority = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter scheduled time: ");
				String time = sc.nextLine();

				scheduler.scheduleBackup(path, priority, time);
				break;

			case 2:
				scheduler.executeBackups();
				break;

			case 3:
				System.out.println("Exiting Backup Scheduler. 💾");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice, try again.");
			}
		}
	}
}
