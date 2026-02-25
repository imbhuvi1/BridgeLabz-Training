package gcr_codebase.functional_interface;

interface DataExport {
	void exportToCSV();

	void exportToPDF();

	default void exportToJSON() {
		System.out.println("Exporting to JSON");
	}
}

class ILovePdf implements DataExport {

	@Override
	public void exportToCSV() {
		// TODO Auto-generated method stub
		System.out.println("ILovePdf exporting to CSV");
	}

	@Override
	public void exportToPDF() {
		// TODO Auto-generated method stub
		System.out.println("ILovePdf exporting to PDF");
	}
}

class WordConverter implements DataExport {
	
	@Override
	public void exportToCSV() {
		// TODO Auto-generated method stub
		System.out.println("WordConverter exporting to CSV");
	}

	@Override
	public void exportToPDF() {
		// TODO Auto-generated method stub
		System.out.println("WordConverter exporting to PDF");
	}
	
	@Override
	public void exportToJSON() {
		System.out.println("WordConverter exporting to JSON");
	}
}

public class DataExportFeature {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataExport iLovePdf = new ILovePdf();
		DataExport wordConverter = new WordConverter();
		
		iLovePdf.exportToCSV();
		iLovePdf.exportToPDF();
		iLovePdf.exportToJSON();
		
		wordConverter.exportToCSV();
		wordConverter.exportToPDF();
		wordConverter.exportToJSON();
	}

}