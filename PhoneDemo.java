import java.io.*;

class PhoneDemo{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			System.out.print("1.Search name and display phone number"+
			"\n2.Add new name-phone number pair"+
			"\n3.Exit"+
			"\nEnter your choice (1-3):");
			int ch = Integer.parseInt(br.readLine());
	
			switch(ch){
			case 1:
				System.out.print("Enter name to be searched:");
				String str = br.readLine();
				String s = "";
				BufferedReader fromFile = new BufferedReader(
							new FileReader("phone.txt"));
				while((s=fromFile.readLine())!=null){
					int i = s.indexOf(" ");
					String name = s.substring(0,i);
					String phone = s.substring(i+1);

					if(name.equals(str)){
						System.out.println("Phone:"+phone);
						break;
					}
				}
				if(s==null)
					System.out.println("Name "+str+" not found.");
				fromFile.close();
				break;
			case 2:
				System.out.print("Enter name:");
				String name = br.readLine();
				System.out.print("Enter phone:");
				String phone = br.readLine();
				BufferedWriter toFile = new BufferedWriter(
						new FileWriter("phone.txt",true));
				toFile.write(name+" "+phone+"\n");
				toFile.close();
				break;
			case 3:
				System.exit(0);
			}
		}
	}
}
