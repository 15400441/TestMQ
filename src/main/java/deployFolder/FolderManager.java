package deployFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FolderManager {

	private String changeRootFolder = "";
	private String changeFolderName = "";
	private String sourceRootFolder = "";
	private String[] sourceFiles;
	private String[] sourceDirs;
	
	private List<String> successCases=new LinkedList<>();
	private List<String> failedCases=new LinkedList<>();

	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		// String str = "D:/a/b/abc_ddg_f";

		// System.out.println(str.matches(".*abc_.*"));

		
			FolderManager fm=new FolderManager();
			fm.changeFolder();
			System.out.println("finished");
			
			
			
			// deleteDir(Paths.get("D:/test/sourceCopy"));
			// copyDir(Paths.get("D:/test/source"),
			// Paths.get("D:/test/sourceCopy"));

		

	}

	public FolderManager() {
		Properties p = new Properties();
		try {
			String confPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator
					+ "config.properties";
			p.load(new FileInputStream(new File(confPath)));
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		changeRootFolder = p.getProperty("changeRootFolder");
		changeFolderName = p.getProperty("changeFolderName");

		sourceDirs = p.getProperty("sourceDir").split(";");
		sourceFiles = p.getProperty("sourceFile").split(";");
		sourceRootFolder = p.getProperty("sourceRootFolder");

	}

	public List<Path> extractAllFolderNeedChange() {
		List<Path> fs = new LinkedList<Path>();

		try {
			Files.list(Paths.get(changeRootFolder)).forEach((path) -> {
				if (path.toString().matches(changeFolderName)) {
					fs.add(path);
				}

			});
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return fs;
	}

	public void changeFolder() {
		System.out.println("running...");
		List<Path> changeFolders = extractAllFolderNeedChange();

		for (Path p : changeFolders) {
			
			Boolean flag=true;

			try {

				for (String dir : sourceDirs) {

					// String name = dir;

					// Path pathNeedChange = Paths.get(p.toString(), name);

					Path source = Paths.get(sourceRootFolder, dir);
					Path target = Paths.get(p.toString(), dir);

					Path clearDir = Paths.get(target.toString());

					deleteDir(clearDir);

					copyDir(source, target);

				}

				for (String f : sourceFiles) {
					// String name = f;

					// Path pathNeedChange = Paths.get(p.toString(), name);

					Path source = Paths.get(sourceRootFolder, f);
					Path target = Paths.get(p.toString(), f);

					Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

				}

			} catch (Exception e) {
				e.printStackTrace();
				flag=false;
			}
			
			if(flag){
				successCases.add(p.getFileName().toString());
			}else{
				failedCases.add(p.getFileName().toString());
			}

		}
		
		System.out.println("success upgrade: "+successCases);
		System.out.println("failed upgrade: "+failedCases);

	}

	public static void copyDir(Path source, Path target) throws IOException {
		if (!Files.exists(source)) {
			return;
		}

		if (!Files.isDirectory(source)) {
			return;
		}

		// create dir

		Files.createDirectory(target);

		Files.list(source).forEach(p -> {

			try {
				if (Files.isDirectory(p)) {
					copyDir(p, Paths.get(target.toString(), p.getFileName().toString()));
				} else {

					Files.copy(p, Paths.get(target.toString(), p.getFileName().toString()),
							StandardCopyOption.REPLACE_EXISTING);
				}
			} catch (IOException e) {

				e.printStackTrace();
			}

		});

	}
	
	

	public static void deleteDir(Path p) throws IOException {

		FileUtils.deleteDirectory(p.toFile());

		/*
		 * 
		 * if (!Files.exists(p)) { return; }
		 * 
		 * if (!Files.isDirectory(p)) { throw new
		 * InvalidDirException("path is not directory"); }
		 * 
		 * 
		 * 
		 * Files.list(p).forEach(cp->{
		 * 
		 * try{
		 * 
		 * if (Files.isDirectory(cp)){
		 * 
		 * deleteDir(cp);
		 * 
		 * }else{ Files.deleteIfExists(cp); }
		 * 
		 * }catch(Exception e){ e.printStackTrace(); } });
		 * 
		 * 
		 */
	}

}
