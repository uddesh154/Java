import java.io.*;

class ItemInfo{
	private int id,quantity;
	private String name;
	private float price;

	ItemInfo(){
	}

	ItemInfo(int id,String name,float price,int quantity){
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}

	ItemInfo(ItemInfo t){
		id = t.id;
		name = t.name;
		price = t.price;
		quantity = t.quantity;
	}

	void store(RandomAccessFile f) throws Exception{
		f.writeInt(id);
		f.writeUTF(name);
		f.writeFloat(price);
		f.writeInt(quantity);
	}

	void access(RandomAccessFile f) throws Exception{
		id=f.readInt();
		name=f.readUTF();
		price=f.readFloat();
		quantity=f.readInt();
	}

	public String toString(){
		return "Id = "+id+"\tName= "+name+"\tPrice= "+price+"\tQuantity = "+quantity;
	}

	public String getName(){
		return name;
	}

	public float getPrice(){
		return price;
	}
}

class RandomAccessFileDemo{
	public static void main(String args[])throws Exception{
		RandomAccessFile f=new RandomAccessFile("item.dat","rw");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		ItemInfo info=new ItemInfo();

		System.out.println("Enter no.of items:");
		int n=Integer.parseInt(br.readLine());

		for(int i=0;i<n;i++){
			System.out.print("Enter Item Id : ");
			int id=Integer.parseInt(br.readLine());

			System.out.print("Enter Item Name : ");
			String name=br.readLine();

			System.out.print("Enter Item Price : ");
			float p=Float.parseFloat(br.readLine());

			System.out.print("Enter Item Quantity : ");
			int qty=Integer.parseInt(br.readLine());

			info=new ItemInfo(id,name,p,qty);

			info.store(f);
		}
		f.close();

		f=new RandomAccessFile("item.dat","rw");

		while(true){
			System.out.print("1.Search for a specific item by name"+
					"\n2.Find costliest item"+
					"\n3.Display all items and total cost"+
					"\n4.Exit"+
					"\nEnter your choice (1-4):");
			int ch=Integer.parseInt(br.readLine());
			switch(ch){
			case 1:
				System.out.println("Enter name to be searched :");
				String name=br.readLine();
				boolean found=false;
				f.seek(0);
				for(int i=0;i<n;i++)
				{
					info.access(f);
					if(info.getName().equals(name)){
						System.out.println(info);
						found=true;
						break;
					}
				}
				if(!found)
					System.out.println("Item "+name+" not found.");
				break;
			case 2: 
				f.seek(0);
				float max=-9999;
				ItemInfo maxItem=null;
				
				for(int i=0;i<n;i++)
				{
					info.access(f);
					if(info.getPrice()>max){
						max = info.getPrice();
						maxItem = new ItemInfo(info);
					}
				}
				System.out.println("Costliest Item:"+maxItem);
				break;
			case 3 :
				f.seek(0);
				float total=0;
				for(int i=0;i<n;i++)
				{
					info.access(f);
					total+=info.getPrice();
					System.out.println(info);
				}
				System.out.println("Total Cost : "+total);
				break;
			case 4:
				System.exit(0);
			}	
		}
	}
}
