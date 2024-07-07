import java.util.*;
import java.io.*;
class Petshop 
{
    int x, tag;
    Scanner in;
    void menu() {
        int ch;
        in = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter your choice");
            System.out.println(" 1 to add");
            System.out.println(" 2 to view");
            System.out.println(" 3 to delete");
            System.out.println(" 4 to sell");
            System.out.println(" 5 to report");
            System.out.println(" 6  to change usernameand pasword");
            ch = in.nextInt();
            System.out.println("Your input="+ch);
            switch (ch) {
                case 1:
                    add();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    del();
                    break;
                case 4:
                    sell();
                    break;
                case 5:
                    report();
                    break;
                    case 6:
                    changepassword();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            System.out.println(" \nDo you want to continue? Enter yes-y or no-n");
            char c1 = in.next().charAt(0);
            if (c1 == 'n') {
                System.exit(0);
            }
        }
    }

    void add() {
        String pt, pq, pp, pg, pc, pa,pb, al = "";
        char c1;
        in = new Scanner(System.in);
        try {
            RandomAccessFile file = new RandomAccessFile("petinfo.txt", "rw");
            file.seek(file.length());

            do {
                System.out.println("Enter pet type");
                pt = in.next();
                System.out.println("Enter pet quantity");
                pq = in.next();
                System.out.println("Pet price");
                pp = in.next();
                System.out.println("Enter pet gender");
                pg = in.next();
                System.out.println("Enter pet color");
                pc = in.next();
                System.out.println("Enter Pet age");
                pa=in.next();
                System.out.println("Enter pet Breed");
                pb=in.next();
                al = pt + "_" + pq + "@" + pp + "#" + pg + "&" + pc +"!"+pa+"*"+pb+"\r\n";
                file.write(al.getBytes());
                System.out.println(" \nDo you want to continue? Enter yes-y or no-n");
                c1 = in.next().charAt(0);
            } while (c1 == 'y');

            file.close();
            System.out.println("New record added\n");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    void view() {
        String da, pt, pq, pc, pp, pg, al,pa,pb;
        int t, q, p, g,x,y;
        try {
            FileReader rd = new FileReader("petinfo.txt");
            BufferedReader re = new BufferedReader(rd);
            System.out.println("\n----------------------Pet info-----------------------");
            System.out.println("name--quantity---price----gender----color-----age--------breed");
            while (true) {
                da = re.readLine();
                if (da == null) {
                    break;
                }
                t = da.indexOf('_');
                q = da.indexOf('@');
                p = da.indexOf('#');
                g = da.indexOf('&');
                x=da.indexOf("!");
                y=da.indexOf("*");
                pt = da.substring(0, t);
                pq = da.substring(t + 1, q);
                pp = da.substring(q + 1, p);
                pg = da.substring(p + 1, g);
                pc = da.substring(g + 1,x);
                pa=da.substring(x+1, y);
                pb=da.substring(y+1);
                System.out.printf("\n%-8s%-9s%-10s%-10s%-9s%-11s%-11s\n", pt, pq, pp, pg, pc,pa,pb);
            }
            re.close();
            rd.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    public void report() {
        String da, pt, pq, pc, pp,al, pg, cn, ca,pa,pb;
        int t, q, p, g, r, s,x,y;
        try {
            FileReader rd9 = new FileReader("petsell.txt");
            BufferedReader re9 = new BufferedReader(rd9);
            System.out.println("-------------------------Pet Sell report------------------------------\n");
            System.out.print("name-qty-price----gender----color----customer----Address-----age---breed");
            while (true) {
                da = re9.readLine();
                if (da == null) {
                    break;
                }
                t = da.indexOf('_');
                q = da.indexOf('@');
                p = da.indexOf('#');
                g = da.indexOf('&');
                r=da.indexOf("%");
                s=da.indexOf("$");
                x=da.indexOf("!");
                y=da.indexOf("*");
                pt = da.substring(0, t);
                pq = da.substring(t + 1, q);
                pp = da.substring(q + 1, p);
                pg = da.substring(p + 1, g);
                pc = da.substring(g + 1,r);
                cn=da.substring(r+1,s);
                ca=da.substring(s+1,x);
                pa=da.substring(x+1,y);
                pb=da.substring(y+1);
                
                System.out.printf("\n%-5s%-4s%-10s%-9s%-9s%-12s%-12s%-6s%-3s", pt, pq, pp, pg, pc,cn,ca,pa,pb);
                System.out.println("");
            }
            re9.close();
            rd9.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    

    void sell() {
        String petname, pp, pt, pg, pc, pq, al, da, pr,cname,caddress,pa,pb,peta,petb;
        int tag = 0, t, q, p, g,x,y, num, n;
        System.out.println("Enter pet name to sell");
        in = new Scanner(System.in);
        petname = in.next();
        System.out.println("Enter pet Quantity to sell");
        num = in.nextInt();
        System.out.println("Enter  Pet age ");
        pa=in.next();
        System.out.println("Enter Pet Breed");
        pb=in.next();
        System.out.println("Enter Customer name");
        cname=in.next();
        System.out.println("Enter Customer Address");
        caddress=in.next();

       
        try {
            FileReader rd = new FileReader("petinfo.txt");
            BufferedReader re = new BufferedReader(rd);
            FileWriter we = new FileWriter("tmp.txt");
            BufferedWriter ww = new BufferedWriter(we);
            RandomAccessFile file = new RandomAccessFile("petsell.txt", "rw");
            file.seek(file.length());
            while (true) {
                da = re.readLine();
                if (da == null) {
                    break;
                }
                t = da.indexOf('_');
                q = da.indexOf('@');
                p = da.indexOf('#');
                g = da.indexOf('&');
                x= da.indexOf("!");
                y=da.indexOf("*");
                pt = da.substring(0, t);
                pq = da.substring(t + 1, q);
                pp = da.substring(q + 1, p);
                pg = da.substring(p + 1, g);
                pc = da.substring(g + 1,x);
                peta=da.substring(x+1,y);
                petb=da.substring(y+1);
                n = Integer.parseInt(pq);
                if ((pt.equals(petname)) && (num <= n)&&(peta.equals(pa))&&(petb.equals(pb))) {
                    n = n - num;
                    pq = Integer.toString(num);
                    pr = pt + "_" + pq + "@" + pp + "#" + pg + "&" + pc+"%"+cname+"$"+caddress+"!"+pa+"*"+pb+ "\r\n";
                    file.write(pr.getBytes());
                    pq = Integer.toString(n);
                    if (n != 0) {
                        al = pt + "_" + pq + "@" + pp + "#" + pg + "&" + pc+"!"+pa+"*"+pb+"\r\n";
                        ww.write(al);
                    }
                    tag = 1;
                } else {
                    al = pt + "_" + pq + "@" + pp + "#" + pg + "&" + pc +"!"+pa+"*"+pb+"\r\n";
                    ww.write(al);
                    if((!pa.equals(peta))&&(!pb.equals(petb)))
                    {
                        System.out.println("data not found");
                    }
                }
            }
            re.close();
            ww.close();
            rd.close();
            we.close();
            file.close();
            if (tag == 1) {
              FileReader rd1 = new FileReader("tmp.txt");
              BufferedReader re1= new BufferedReader(rd1);
              FileWriter wr1 = new FileWriter("petinfo.txt");
              BufferedWriter ww1= new BufferedWriter(wr1);
              while(true)
              {
                da=re1.readLine();
                if(da==null)
                {
                    break;
                }
                ww1.write(da+"\r\n");
              }
                System.out.println(petname + " sold and updated.");
                ww1.close();
                wr1.close();
                re1.close();
                rd1.close();
            } else {
                System.out.println("Not found");
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    void del() {
        String petname, pp, pt, pg, pc, pq, al, da, pr;
        int tag = 0, t, q, p, g, num, n;
        System.out.println("Enter pet name to delete");
        in = new Scanner(System.in);
        petname = in.next();
        try {
            FileReader rd2 = new FileReader("petinfo.txt");
            BufferedReader re2 = new BufferedReader(rd2);
            FileWriter we2 = new FileWriter("tmp.txt");
            BufferedWriter ww2 = new BufferedWriter(we2);
            while (true) {
                da = re2.readLine();
                if (da == null) {
                    break;
                }
                t = da.indexOf('_');
                q = da.indexOf('@');
                p = da.indexOf('#');
                g = da.indexOf('&');
                pt = da.substring(0, t);
                pq = da.substring(t + 1, q);
                pp = da.substring(q + 1, p);
                pg = da.substring(p + 1, g);
                pc = da.substring(g + 1);
                if (pt.equals(petname)) {
                    tag=1;
                    System.out.println("pet deleted");
                } if(tag!=1){
                    ww2.write(da);
                }
                else{

                    tag=0;
                }
                  
                
            }
            re2.close();
            ww2.close();
            rd2.close();
            we2.close();
            FileReader rd1 = new FileReader("tmp.txt");
            BufferedReader re1= new BufferedReader(rd1);
            FileWriter wr1 = new FileWriter("petinfo.txt");
            BufferedWriter ww1= new BufferedWriter(wr1);
            while(true)
            {
              da=re1.readLine();
              if(da==null)
              {
                  break;
              }
              ww1.write(da+"\r\n");
            }
             
              ww1.close();
              wr1.close();
              re1.close();
              rd1.close();
          
       
        
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    public static void main(String args[])
    {
        int c;
        String un1,ps1,un2,ps2;
        Petshop p = new Petshop();
        try{
            Scanner in = new Scanner(System.in);
            FileInputStream wel = new FileInputStream("welcome.txt");
            FileReader va= new FileReader("valid.txt");
            BufferedReader valid = new BufferedReader(va);
            while(true){
                c=wel.read();
                if(c==-1)
                {
                    break;
                }
            System.out.println((char)c);
            }
            int tag=0;
            un1=valid.readLine();
            ps1=valid.readLine();
            for( int i=0;i<3;i++)
            {
                System.out.print("Enter user name\t ");
                un2=in.next();
                System.out.print("Enter password\t");
                ps2=in.next();
                if((un1.equals(un2))&&(ps1.equals(ps2)))
                {
                    System.out.println("\nWelcome\t"+un1);
                    p.menu();
                    tag=1;
                    break;
                }
                else{
                    if(!un1.equals(un2))
                    {
                        System.out.println("Invalid Username");
                    }
                    else{
                        System.out.println("Invalid Password");
                    }
                    System.out.println("try again\n");
                    if(i==2)
                    {
                        System.out.println("sorry  max attempts ");
                        System.exit(0);
                    }
                }
            }
            if(tag==0)
            {
                System.out.println("Wrong user name");
            }
	wel.close();
	va.close();
	valid.close();
        }
        catch (Exception e)
        {
            System.out.println("error");
        }
    }
    void changepassword()
    {
        String d;
       String password;
        String input;
        System.out.println(" enter  new user name");
        Scanner in=new Scanner(System.in);
        input=in.next();
        System.out.println("Enter new password");
        password=in.next();
       try{
        FileReader va= new FileReader("valid.txt");
        BufferedReader valid = new BufferedReader(va);
        FileWriter rd2 = new FileWriter("tmp.txt");
        BufferedWriter re2 = new BufferedWriter(rd2);
        while(true)
        {
        
           d=valid.readLine();
           if(d==null)
           {
            break;
           }
          re2.write(d+"\n");
        }
        valid.close(); 
        re2.close();
        rd2.close();
        va.close();
        FileReader va1= new FileReader("tmp.txt");
        BufferedReader valid1 = new BufferedReader(va1);
        FileWriter rd1 = new FileWriter("valid.txt");
        BufferedWriter re1 = new BufferedWriter(rd1);
        String data;
        
    
            data=valid1.readLine(); 
            re1.write(input+"\n");
            data=valid1.readLine(); 
            re1.write(password+"\n");
    
        valid1.close();
        re1.close();
        rd1.close();
        va1.close();
    }
    
    catch (Exception e)
    {
        System.out.println(e);
    }
}   
}
   

