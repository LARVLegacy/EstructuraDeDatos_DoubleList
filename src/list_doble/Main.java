
package list_doble;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
       DoubleList dl = new DoubleList();
       String name, opt;
       int pos;
       String menu[]={"Add","AddFirst", "AddLast", "Add position", "Print", "RemoveFirst",
            "RemoveLast", "Remove position", "Remove", "Size", "Search", "Exit"};
       
       do{
           opt=(String)JOptionPane.showInputDialog(null, "Selected option", "Main menu",1,null,
                   menu,menu[0]);
            switch(opt)
            {
                case "AddFirst":
                    name=JOptionPane.showInputDialog("Enter name");
                    dl.AddFirst(name);
                    JOptionPane.showMessageDialog(null,"Created name");
                    break;
                    
                case "Print":
                    JOptionPane.showMessageDialog(null,dl.toString(), "DoubleList", 1);
                    break;
                    
                case "AddLast":
                    name=JOptionPane.showInputDialog("Enter name");
                    dl.AddLast(name);
                    JOptionPane.showMessageDialog(null,"Created name");
                    break;
                    
                case "Size":
                    JOptionPane.showMessageDialog(null,"the list have " + dl.Size() + " elements");
                    break;
                
                case "Add position":
                    do{
                        pos = Integer.parseInt(JOptionPane.showInputDialog("Enter pos"));
                    }while(pos<0 || pos>dl.Size()+1);
                    name=JOptionPane.showInputDialog("Enter name");
                    dl.Add(name,pos);
                    JOptionPane.showMessageDialog(null,"Created name");
                    break;
                    
                case "Add":
                    name=JOptionPane.showInputDialog("Enter name");
                    dl.Add(name);
                    JOptionPane.showMessageDialog(null,"Created name");
                    break;
                    
                case "RemoveFirst":
                    if(dl.RemoveFirst())
                        JOptionPane.showMessageDialog(null,"removed name");
                    else
                        JOptionPane.showMessageDialog(null,"list havn´t elements");
                    break;
                    
                case "RemoveLast":
                    if(dl.RemoveLast())
                        JOptionPane.showMessageDialog(null,"removed name");
                    else
                        JOptionPane.showMessageDialog(null,"list havn´t elements");
                    break;
                    
                case "Remove position":
                    if(!dl.isEmpty())
                    {  
                        do{
                            pos = Integer.parseInt(JOptionPane.showInputDialog("Enter pos"));
                        }while(pos<0 || pos>dl.Size());
                        if(dl.Remove(pos))
                            JOptionPane.showMessageDialog(null,"removed name");
                    }
                    else
                        JOptionPane.showMessageDialog(null,"list havn´t elements");
                    break;                        
                case "Remove":
                    if(!dl.isEmpty()){
                        name = JOptionPane.showInputDialog("Enter name");
                        if(dl.Remove(name))
                             JOptionPane.showMessageDialog(null,"removed name");
                        else
                            JOptionPane.showMessageDialog(null,"element not found");
                    }
                    else
                        JOptionPane.showMessageDialog(null,"list havn´t elements");                    
                    break;
                    
            }
       }while(!opt.equals("Exit"));
    }    
}

