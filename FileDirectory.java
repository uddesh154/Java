import java.io.*;

class FileDirectory{
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String dirname=args[0];

		java.io.File f = new java.io.File(dirname);
		if(f.isFile()){
			System.out.println(dirname+" is a file.");
			System.out.println("Path      : "+f.getPath());
			System.out.println("File Size : "+f.length()+" bytes");
		}
		else if(f.isDirectory()){
			System.out.println(dirname+" is a directory.");
			System.out.println("Contents Of : "+dirname);
			String fileNames[]=f.list();
			int cnt=0;
			for(int i=0;i<fileNames.length;i++){
				if(fileNames[i].endsWith(".txt")){	
					cnt++;
					System.out.println(fileNames[i]+" is a File\n");
				}
			}

			System.out.println("Total Number Of Files :"+cnt);
		}
	}
}
