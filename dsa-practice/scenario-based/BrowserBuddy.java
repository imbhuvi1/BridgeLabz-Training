package scenario_based;
import java.util.Stack;

// Doubly Linked List Node
class HistoryNode {
    String url;
    HistoryNode prev;
    HistoryNode next;

    HistoryNode(String url) {
        this.url = url;
    }
}

// Browser Tab with Back & Forward support
class BrowserTab {
    private HistoryNode current;

    // Visit a new page
    public void visit(String url) {
        HistoryNode newNode = new HistoryNode(url);

        if (current != null) {
            current.next = null;      // clear forward history
            current.next = newNode;
            newNode.prev = current;
        }

        current = newNode;
        System.out.println("Visited: " + url);
    }

    // Go back
    public void back() {
        if (current == null || current.prev == null) {
            System.out.println("No previous page.");
            return;
        }
        current = current.prev;
        System.out.println("Back to: " + current.url);
    }

    // Go forward
    public void forward() {
        if (current == null || current.next == null) {
            System.out.println("No forward page.");
            return;
        }
        current = current.next;
        System.out.println("Forward to: " + current.url);
    }

    public String getCurrentPage() {
        return current != null ? current.url : "No page open";
    }
}

// Manages tabs and closed tabs stack
class BrowserManager {
    private BrowserTab activeTab;
    private Stack<BrowserTab> closedTabs = new Stack<>();

    // Open new tab
    public void openTab() {
        activeTab = new BrowserTab();
        System.out.println("New tab opened.");
    }

    // Close current tab
    public void closeTab() {
        if (activeTab == null) {
            System.out.println("No active tab to close.");
            return;
        }
        closedTabs.push(activeTab);
        activeTab = null;
        System.out.println("Tab closed.");
    }

    // Restore last closed tab
    public void restoreTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No tabs to restore.");
            return;
        }
        activeTab = closedTabs.pop();
        System.out.println("Tab restored.");
    }

    public BrowserTab getActiveTab() {
        return activeTab;
    }
}

// Main Class
public class BrowserBuddy {
    public static void main(String[] args) {

        BrowserManager manager = new BrowserManager();

        manager.openTab();
        BrowserTab tab = manager.getActiveTab();

        tab.visit("google.com");
        tab.visit("github.com");
        tab.visit("stackoverflow.com");

        tab.back();
        tab.back();
        tab.forward();

        System.out.println("Current Page: " + tab.getCurrentPage());

        manager.closeTab();
        manager.restoreTab();

        BrowserTab restoredTab = manager.getActiveTab();
        System.out.println("Restored Page: " + restoredTab.getCurrentPage());
    }
}
