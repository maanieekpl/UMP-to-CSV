import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		start();

	}
	
	public static void start() {
		Scanner sc = new Scanner(System.in);
		
		int chose;
		System.out.println("[1] Ulice \n" + 
				"[2] Drogi \n" +
				"[3] Highways \n" + 
				"[4] Woda \n" + 
				"[5] Zielone \n" + 
				"[6] Obszary");
		
		System.out.print("Wybierz jakie pliki chcesz skonwertowaæ: ");
		chose = sc.nextInt();
		
		
		switch (chose) {
		case 1:
			readUlice();
			break;
		case 2:
			readDrogi();
			break;
		case 3:
			readHighways();
			break;
		case 4:
			readWoda();
			break;
		case 5:
			readZielone();
			break;
		case 6:
			readObszary();
			break;
		}
	}
	public static void readUlice() {	
//		String saveFile = "G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/csv/ULICE_table.csv";


			
			Street street;
			ArrayList<Street> listStreet = new ArrayList();
			ArrayList<String> listFile = new ArrayList();
			int counter = 0;
			String source = "G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/";
	    	String split[] = new String[2];
		    
			
			File[] files = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/").listFiles(); //X is the directory
		    String s = "ulice"; //<--- the string you want to check filenames with
		    for(File f : files){
		        if(f.getName().toLowerCase().indexOf(s.toLowerCase()) != -1) {
		        System.out.println(f.getName());
		        listFile.add(f.getName());
		        }
		    }
		    
		    for(int i = 0; i < listFile.size(); i++) {
			
				try {
		
		            File readFile = new File(source + listFile.get(i));
		
		            BufferedReader b = new BufferedReader(new FileReader(readFile));
		
		            String readLine = "";
		
		            System.out.println("Reading file using Buffered Reader" + listFile.get(i));
		            
		            readLine = b.readLine();
		            String city = readLine;
		     
		            
		
		            while ((readLine = b.readLine()) != null) {
//		                System.out.println(readLine);
		                
		                if(readLine.equals("[POLYLINE]")) {
		                	listStreet.add(new Street() );
		                	split = city.split("=");
		                	listStreet.get(counter).setCity(split[1]);
		                }else if(readLine.contains("Type=") && readLine.startsWith("Type") == true) {
		                	split = readLine.split("=");
		                	listStreet.get(counter).setType(split[1]);
		                }else if(readLine.contains("Label=") && readLine.startsWith("Label") == true) {
		                	split = readLine.split("=");
		                	listStreet.get(counter).setLabel(split[1]);
		                }else if(readLine.contains("EndLevel=") && readLine.startsWith("EndLevel") == true) {
		                	split = readLine.split("=");
		                	listStreet.get(counter).setEndLevel(split[1]);
		                }else if(readLine.contains("Data0=") && readLine.startsWith("Data0") == true) {
		                	split = readLine.split("=");
		                	listStreet.get(counter).setData0(split[1]);
		                }else if(readLine.equals("[END]")) {
		                	counter++;
		                }
		            }
		
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
			
//			for (int i = 0; i < counter; i++) {
//				System.out.println(listStreet.get(i).getType() + "\n" +
//						listStreet.get(i).getLabel() + "\n" + 
//						listStreet.get(i).getEndLevel() + "\n" + 
//						listStreet.get(i).getData0() + "\n");
//			}
//				
	        File saveFile = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/csv/ULICE_table.csv");
		
		    try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {

//					String content = "This is the content to write into file\n";
					for (int i = 0; i < counter; i++) {
					bw.write(listStreet.get(i).getCity() + ";" +
							listStreet.get(i).getType() + ";" +
							listStreet.get(i).getLabel() + ";" + 
							listStreet.get(i).getEndLevel() + ";" + 
							listStreet.get(i).getData0() + "\n");
					}
					
					// no need to close it.
					//bw.close();

					System.out.println("Done");

				} catch (IOException e) {

					e.printStackTrace();

				}
			start();
	}
	
	public static void readDrogi() {
		Road road;
		ArrayList<Road> listRoad = new ArrayList();
		ArrayList<String> listFile = new ArrayList();
		int counter = 0;
		String source = "G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/";
    	String split[] = new String[2];
	    
		
		File[] files = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/").listFiles(); //X is the directory
	    String s = "drogi"; //<--- the string you want to check filenames with
	    for(File f : files){
	        if(f.getName().toLowerCase().indexOf(s.toLowerCase()) != -1) {
	        System.out.println(f.getName());
	        listFile.add(f.getName());
	        }
	    }
	    
	    for(int i = 0; i < listFile.size(); i++) {
		
			try {
	
	            File readFile = new File(source + listFile.get(i));
	
	            BufferedReader b = new BufferedReader(new FileReader(readFile));
	
	            String readLine = "";
	
	            System.out.println("Reading file using Buffered Reader" + listFile.get(i));  
	            
	
	            while ((readLine = b.readLine()) != null) {
//	                System.out.println(readLine);
	                
	                if(readLine.equals("[POLYLINE]")) {
	                	listRoad.add(new Road() );
	                }else if(readLine.contains("Type=") && readLine.startsWith("Type") == true) {
	                	split = readLine.split("=");
	                	listRoad.get(counter).setType(split[1]);
	                }else if(readLine.contains("Label=") && readLine.startsWith("Label") == true) {
	                	split = readLine.split("=");
	                	listRoad.get(counter).setLabel(split[1]);
	                }else if(readLine.contains("EndLevel=") && readLine.startsWith("EndLevel") == true) {
	                	split = readLine.split("=");
	                	listRoad.get(counter).setEndLevel(split[1]);
	                }else if(readLine.contains("Data0=") && readLine.startsWith("Data0") == true) {
	                	split = readLine.split("=");
	                	listRoad.get(counter).setData0(split[1]);
	                }else if(readLine.contains("Miasto=") && readLine.startsWith("Miasto") == true) {
		                split = readLine.split("=");	
	                	listRoad.get(counter).setMiasto(split[1]);
	                }else if(readLine.equals("[END]")) {
	                	counter++;
	                }
	            }
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
//		for (int i = 0; i < counter; i++) {
//			System.out.println(listStreet.get(i).getType() + "\n" +
//					listStreet.get(i).getLabel() + "\n" + 
//					listStreet.get(i).getEndLevel() + "\n" + 
//					listStreet.get(i).getData0() + "\n");
//		}
//			
        File saveFile = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/csv/ROAD_table.csv");
	
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {

//				String content = "This is the content to write into file\n";
				for (int i = 0; i < counter; i++) {
				bw.write(listRoad.get(i).getMiasto() + ";" +
						listRoad.get(i).getType() + ";" +
						listRoad.get(i).getLabel() + ";" + 
						listRoad.get(i).getEndLevel() + ";" + 
						listRoad.get(i).getData0() + "\n");
				}
				
				// no need to close it.
				//bw.close();

				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			}
		start();
		
	}
	
	public static void readHighways() {
		Road road;
		ArrayList<Road> listRoad = new ArrayList();
		ArrayList<String> listFile = new ArrayList();
		int counter = 0;
		String source = "G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/";
    	String split[] = new String[2];
    	
    	String tmp = "";
	    
		
		File[] files = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/").listFiles(); //X is the directory
	    String s = "highways"; //<--- the string you want to check filenames with
	    for(File f : files){
	        if(f.getName().toLowerCase().indexOf(s.toLowerCase()) != -1) {
	        System.out.println(f.getName());
	        listFile.add(f.getName());
	        }
	    }
	    
	    for(int i = 0; i < listFile.size(); i++) {
		
			try {
	
	            File readFile = new File(source + listFile.get(i));
	
	            BufferedReader b = new BufferedReader(new FileReader(readFile));
	
	            String readLine = "";
	
	            System.out.println("Reading file using Buffered Reader" + listFile.get(i));  
	            
	
	            while ((readLine = b.readLine()) != null) {
//	                System.out.println(readLine);
	                
	                if(readLine.equals("[POLYLINE]")) {
	                	listRoad.add(new Road() );
	                	tmp = readLine;
	                }else if(readLine.contains("Type=") && readLine.startsWith("Type") == true && tmp.equals("[POLYLINE]")) {
		                	split = readLine.split("=");
		                	listRoad.get(counter).setType(split[1]);
		                }else if(readLine.contains("Label=") && readLine.startsWith("Label") == true && tmp.equals("[POLYLINE]")) {
		                	split = readLine.split("=");
		                	listRoad.get(counter).setLabel(split[1]);
		                }else if(readLine.contains("EndLevel=") && readLine.startsWith("EndLevel") == true && tmp.equals("[POLYLINE]")) {
		                	split = readLine.split("=");
		                	listRoad.get(counter).setEndLevel(split[1]);
		                }else if(readLine.contains("Data0=") && readLine.startsWith("Data0") == true && tmp.equals("[POLYLINE]")) {
		                	split = readLine.split("=");
		                	listRoad.get(counter).setData0(split[1]);
		                }else if(readLine.contains("Miasto=") && readLine.startsWith("Miasto") == true && tmp.equals("[POLYLINE]")) {
			                split = readLine.split("=");	
		                	listRoad.get(counter).setMiasto(split[1]);
		                }else if(readLine.equals("[END]") && tmp.equals("[POLYLINE]")) {
		                	counter++;
		                	tmp = readLine;
		                }
	                
	            }
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
//		for (int i = 0; i < counter; i++) {
//			System.out.println(listStreet.get(i).getType() + "\n" +
//					listStreet.get(i).getLabel() + "\n" + 
//					listStreet.get(i).getEndLevel() + "\n" + 
//					listStreet.get(i).getData0() + "\n");
//		}
//			
        File saveFile = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/csv/HIGHWAYS_table.csv");
	
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {

//				String content = "This is the content to write into file\n";
				for (int i = 0; i < counter; i++) {
				bw.write(listRoad.get(i).getMiasto() + ";" +
						listRoad.get(i).getType() + ";" +
						listRoad.get(i).getLabel() + ";" + 
						listRoad.get(i).getEndLevel() + ";" + 
						listRoad.get(i).getData0() + "\n");
				}
				
				// no need to close it.
				//bw.close();

				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			}
		start();
		
	}

	public static void readWoda(){
		Lake lake;
		River river;
		ArrayList<Lake> listLake = new ArrayList();
		ArrayList<River> listRiver = new ArrayList();
		ArrayList<String> listFile = new ArrayList();
		int lakeCounter = 0;
		int riverCounter = 0;
		String source = "G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/";
    	String split[] = new String[2];
    	
    	String tmp = "";
	    
		
		File[] files = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/").listFiles(); //X is the directory
	    String s = "woda"; //<--- the string you want to check filenames with
	    for(File f : files){
	        if(f.getName().toLowerCase().indexOf(s.toLowerCase()) != -1) {
	        System.out.println(f.getName());
	        listFile.add(f.getName());
	        }
	    }
	    
	    for(int i = 0; i < listFile.size(); i++) {
		
			try {
	
	            File readFile = new File(source + listFile.get(i));
	
	            BufferedReader b = new BufferedReader(new FileReader(readFile));
	
	            String readLine = "";
	
	            System.out.println("Reading file using Buffered Reader" + listFile.get(i));  
	            
	
	            while ((readLine = b.readLine()) != null) {
//	                System.out.println(readLine);
	                
	                if(readLine.equals("[POLYLINE]")) {
	                	listRiver.add(new River() );
	                	tmp = readLine;
	                }else if(readLine.contains("Type=") && readLine.startsWith("Type") == true && tmp.equals("[POLYLINE]")) {
		               	split = readLine.split("=");
		               	listRiver.get(riverCounter).setType(split[1]);
		            }else if(readLine.contains("Label=") && readLine.startsWith("Label") == true && tmp.equals("[POLYLINE]")) {
		               	split = readLine.split("=");
		               	listRiver.get(riverCounter).setLabel(split[1]);
		            }else if(readLine.contains("EndLevel=") && readLine.startsWith("EndLevel") == true && tmp.equals("[POLYLINE]")) {
		               	split = readLine.split("=");
		               	listRiver.get(riverCounter).setEndLevel(split[1]);
		            }else if(readLine.contains("Data0=") && readLine.startsWith("Data0") == true && tmp.equals("[POLYLINE]")) {
		               	split = readLine.split("=");
		               	listRiver.get(riverCounter).setData0(split[1]);
		            }else if(readLine.equals("[END]") && tmp.equals("[POLYLINE]")) {
		                	riverCounter++;
		                	tmp = readLine;
		               
	                }
	               
	                
	                if(readLine.equals("[POLYGON]")) {
	                	listLake.add(new Lake() );
	                	tmp = readLine;
	                }if(readLine.contains("Type=") && readLine.startsWith("Type") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listLake.get(lakeCounter).setType(split[1]);
		            }else if(readLine.contains("Label=") && readLine.startsWith("Label") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listLake.get(lakeCounter).setLabel(split[1]);
		            }else if(readLine.contains("EndLevel=") && readLine.startsWith("EndLevel") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listLake.get(lakeCounter).setEndLevel(split[1]);
		            }else if(readLine.contains("Data0=") && readLine.startsWith("Data0") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listLake.get(lakeCounter).setData0(split[1]);
		            }else if(readLine.contains("Miasto=") && readLine.startsWith("Miasto") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listLake.get(lakeCounter).setCity(split[1]);
		            }else if(readLine.equals("[END]") && tmp.equals("[POLYGON]")) {
		                	lakeCounter++;
		                	tmp = readLine;

	                }
	            }
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
//		for (int i = 0; i < counter; i++) {
//			System.out.println(listStreet.get(i).getType() + "\n" +
//					listStreet.get(i).getLabel() + "\n" + 
//					listStreet.get(i).getEndLevel() + "\n" + 
//					listStreet.get(i).getData0() + "\n");
//		}
//			
        File saveFile = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/csv/RIVER_table.csv");
	
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {

//				String content = "This is the content to write into file\n";
				for (int i = 0; i < riverCounter; i++) {
				bw.write(listRiver.get(i).getType() + ";" +
						listRiver.get(i).getLabel() + ";" + 
						listRiver.get(i).getEndLevel() + ";" + 
						listRiver.get(i).getData0() + "\n");
				}
				
				// no need to close it.
				//bw.close();

				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			}
	    
        saveFile = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/csv/LAKE_table.csv");
    	
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {

//				String content = "This is the content to write into file\n";
				for (int i = 0; i < lakeCounter; i++) {
				bw.write(listLake.get(i).getCity() + ";" +
						listLake.get(i).getType() + ";" +
						listLake.get(i).getLabel() + ";" + 
						listLake.get(i).getEndLevel() + ";" + 
						listLake.get(i).getData0() + "\n");
				}
				
				// no need to close it.
				//bw.close();

				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			}
		start();
	}

	public static void readZielone(){
		Zielone zielone;
		ArrayList<Zielone> listZielone = new ArrayList();
		ArrayList<String> listFile = new ArrayList();
		int counter = 0;
		String source = "G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/";
    	String split[] = new String[2];
    	
    	String tmp = "";
	    
		
		File[] files = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/").listFiles(); //X is the directory
	    String s = "zielone"; //<--- the string you want to check filenames with
	    for(File f : files){
	        if(f.getName().toLowerCase().indexOf(s.toLowerCase()) != -1) {
	        System.out.println(f.getName());
	        listFile.add(f.getName());
	        }
	    }
	    
	    for(int i = 0; i < listFile.size(); i++) {
		
			try {
	
	            File readFile = new File(source + listFile.get(i));
	
	            BufferedReader b = new BufferedReader(new FileReader(readFile));
	
	            String readLine = "";
	
	            System.out.println("Reading file using Buffered Reader" + listFile.get(i));  
	            
	
	            while ((readLine = b.readLine()) != null) {
//	                System.out.println(readLine);
	                
	                if(readLine.equals("[POLYGON]")) {
	                	listZielone.add(new Zielone() );
	                	tmp = readLine;
	                }if(readLine.contains("Type=") && readLine.startsWith("Type") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listZielone.get(counter).setType(split[1]);
		            }else if(readLine.contains("Label=") && readLine.startsWith("Label") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listZielone.get(counter).setLabel(split[1]);
		            }else if(readLine.contains("EndLevel=") && readLine.startsWith("EndLevel") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listZielone.get(counter).setEndLevel(split[1]);
		            }else if(readLine.contains("Data0=") && readLine.startsWith("Data0") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listZielone.get(counter).setData0(split[1]);
		            }else if(readLine.contains("Miasto=") && readLine.startsWith("Miasto") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listZielone.get(counter).setCity(split[1]);
		            }else if(readLine.equals("[END]") && tmp.equals("[POLYGON]")) {
		            	counter++;
		                	tmp = readLine;

	                }
	            }
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
        File saveFile = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/csv/ZIELONE_table.csv");

	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {

//				String content = "This is the content to write into file\n";
				for (int i = 0; i < counter; i++) {
				bw.write(listZielone.get(i).getCity() + ";" +
						listZielone.get(i).getType() + ";" +
						listZielone.get(i).getLabel() + ";" + 
						listZielone.get(i).getEndLevel() + ";" + 
						listZielone.get(i).getData0() + "\n");
				}
				
				// no need to close it.
				//bw.close();

				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			}
		start();
		
	}

	public static void readObszary(){
		ObszarPolyline obszarPolyline;
		ObszarPolygon obszarPolygon;
		ArrayList<ObszarPolyline> listObszarPolyline = new ArrayList();
		ArrayList<ObszarPolygon> listObszarPolygon = new ArrayList();
		ArrayList<String> listFile = new ArrayList();
		int obszarPolylineCounter = 0;
		int obszarPolygonCounter = 0;
		String source = "G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/";
    	String split[] = new String[2];
    	
    	String tmp = "";
	    
		
		File[] files = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/ump/UMP-PL-Wroclaw/src/").listFiles(); //X is the directory
	    String s = "obszary"; //<--- the string you want to check filenames with
	    for(File f : files){
	        if(f.getName().toLowerCase().indexOf(s.toLowerCase()) != -1) {
	        System.out.println(f.getName());
	        listFile.add(f.getName());
	        }
	    }
	    
	    for(int i = 0; i < listFile.size(); i++) {
		
			try {
	
	            File readFile = new File(source + listFile.get(i));
	
	            BufferedReader b = new BufferedReader(new FileReader(readFile));
	
	            String readLine = "";
	
	            System.out.println("Reading file using Buffered Reader" + listFile.get(i));  
	            
	
	            while ((readLine = b.readLine()) != null) {
//	                System.out.println(readLine);
	                
	                if(readLine.equals("[POLYLINE]")) {
	                	listObszarPolyline.add(new ObszarPolyline() );
	                	tmp = readLine;
	                }else if(readLine.contains("Type=") && readLine.startsWith("Type") == true && tmp.equals("[POLYLINE]")) {
		               	split = readLine.split("=");
		               	listObszarPolyline.get(obszarPolylineCounter).setType(split[1]);
		            }else if(readLine.contains("Label=") && readLine.startsWith("Label") == true && tmp.equals("[POLYLINE]")) {
		               	split = readLine.split("=");
		               	listObszarPolyline.get(obszarPolylineCounter).setLabel(split[1]);
		            }else if(readLine.contains("EndLevel=") && readLine.startsWith("EndLevel") == true && tmp.equals("[POLYLINE]")) {
		               	split = readLine.split("=");
		               	listObszarPolyline.get(obszarPolylineCounter).setEndLevel(split[1]);
		            }else if(readLine.contains("Data0=") && readLine.startsWith("Data0") == true && tmp.equals("[POLYLINE]")) {
		               	split = readLine.split("=");
		               	listObszarPolyline.get(obszarPolylineCounter).setData0(split[1]);
		            }else if(readLine.equals("[END]") && tmp.equals("[POLYLINE]")) {
		            	obszarPolylineCounter++;
		                tmp = readLine;
		               
	                }
	               
	                
	                if(readLine.equals("[POLYGON]")) {
	                	listObszarPolygon.add(new ObszarPolygon() );
	                	tmp = readLine;
	                }if(readLine.contains("Type=") && readLine.startsWith("Type") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listObszarPolygon.get(obszarPolygonCounter).setType(split[1]);
		            }else if(readLine.contains("Label=") && readLine.startsWith("Label") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listObszarPolygon.get(obszarPolygonCounter).setLabel(split[1]);
		            }else if(readLine.contains("EndLevel=") && readLine.startsWith("EndLevel") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listObszarPolygon.get(obszarPolygonCounter).setEndLevel(split[1]);
		            }else if(readLine.contains("Data0=") && readLine.startsWith("Data0") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listObszarPolygon.get(obszarPolygonCounter).setData0(split[1]);
		            }else if(readLine.contains("Miasto=") && readLine.startsWith("Miasto") == true && tmp.equals("[POLYGON]")) {
		               	split = readLine.split("=");
		               	listObszarPolygon.get(obszarPolygonCounter).setCity(split[1]);
		            }else if(readLine.equals("[END]") && tmp.equals("[POLYGON]")) {
		            	obszarPolygonCounter++;
		                	tmp = readLine;

	                }
	            }
	
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
//		for (int i = 0; i < counter; i++) {
//			System.out.println(listStreet.get(i).getType() + "\n" +
//					listStreet.get(i).getLabel() + "\n" + 
//					listStreet.get(i).getEndLevel() + "\n" + 
//					listStreet.get(i).getData0() + "\n");
//		}
//			
        File saveFile = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/csv/OBSZAR_POLYLINE_table.csv");
	
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {

//				String content = "This is the content to write into file\n";
				for (int i = 0; i < obszarPolylineCounter; i++) {
				bw.write(listObszarPolyline.get(i).getCity() + ";" +
						listObszarPolyline.get(i).getType() + ";" +
						listObszarPolyline.get(i).getLabel() + ";" + 
						listObszarPolyline.get(i).getEndLevel() + ";" + 
						listObszarPolyline.get(i).getData0() + "\n");
				}
				
				// no need to close it.
				//bw.close();

				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			}
	    
        saveFile = new File("G:/OneDrive - uk elcass/Studia/#Praca_Magisterska/Materia³y/Mapa/csv/OBSZAR_POLYGON_table.csv");
    	
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile))) {

//				String content = "This is the content to write into file\n";
				for (int i = 0; i < obszarPolygonCounter; i++) {
				bw.write(listObszarPolygon.get(i).getCity() + ";" +
						listObszarPolygon.get(i).getType() + ";" +
						listObszarPolygon.get(i).getLabel() + ";" + 
						listObszarPolygon.get(i).getEndLevel() + ";" + 
						listObszarPolygon.get(i).getData0() + "\n");
				}
				
				// no need to close it.
				//bw.close();

				System.out.println("Done");

			} catch (IOException e) {

				e.printStackTrace();

			}
		start();
		
	
	}
	

}


	

