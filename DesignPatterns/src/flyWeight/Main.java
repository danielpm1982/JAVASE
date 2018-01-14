package flyWeight;
import java.awt.Point;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FlyWeight> allFlyWeightList = new ArrayList<>();
        List<MyFrameInterface> allFrameList = new ArrayList<>();
        for(int i=0;i<10;i++){            
            MyFrameInterface frame = new MyFrame();
            ((MyFrame)frame).setLocation(getRandomPoint());
            allFrameList.add(frame);
            
            FlyWeight flyWeight1 = FlyWeightSingletonFactory.getFlyWeight(FlyWeightConcreteShared1.class);
            FlyWeight flyWeight2 = FlyWeightSingletonFactory.getFlyWeight(FlyWeightConcreteShared2.class);
            FlyWeight flyWeight3 = FlyWeightSingletonFactory.getFlyWeight(FlyWeightConcreteShared3.class);
            
//            FlyWeight flyWeight1 = new FlyWeightConcreteShared1();
//            FlyWeight flyWeight2 = new FlyWeightConcreteShared2();
//            FlyWeight flyWeight3 = new FlyWeightConcreteShared3();
            
            allFlyWeightList.addAll(Arrays.asList(flyWeight1, flyWeight2, flyWeight3));
            flyWeight1.display(frame);
            flyWeight2.display(frame);
            flyWeight3.display(frame);
        }
        allFrameList.forEach(x->{((MyFrame)x).repaint();((MyFrame)x).setVisible(true);});
        System.out.println("All flyWeights list of elements: "+allFlyWeightList.size()+".");
        System.out.println("Number of FlyWeightConcreteShared1 elements in the list: "+allFlyWeightList.stream().filter(x->x.getClass().getSimpleName().equals("FlyWeightConcreteShared1")).count());
        System.out.println("Number of FlyWeightConcreteShared2 elements in the list: "+allFlyWeightList.stream().filter(x->x.getClass().getSimpleName().equals("FlyWeightConcreteShared2")).count());
        System.out.println("Number of FlyWeightConcreteShared3 elements in the list: "+allFlyWeightList.stream().filter(x->x.getClass().getSimpleName().equals("FlyWeightConcreteShared3")).count());
        System.out.print("Are the FlyWeightConcreteShared1 elements one same instance (allFlyWeightConcreteShared1Array[0]==allFlyWeightConcreteShared1Array[1]) ? ");
        FlyWeight[] allFlyWeightConcreteShared1Array = allFlyWeightList.stream().filter(x->x.getClass().getSimpleName().equals("FlyWeightConcreteShared1")).toArray(FlyWeight[]::new);
        if(allFlyWeightConcreteShared1Array.length>=2){
            System.out.println(allFlyWeightConcreteShared1Array[0]==allFlyWeightConcreteShared1Array[1]?"YES! FlyWeight Pattern Used!":"NO! FlyWeight Pattern NOT used!");
        }
    }
    private static Point getRandomPoint(){
        int x = new SecureRandom().ints(0, 1920-808).findAny().getAsInt();
        int y = new SecureRandom().ints(0, 1080-600).findAny().getAsInt();
        return new Point(x, y);
    }
}

/*
Reduces the number of objects and use of resources (memory) at runtime, and centralizes in a central client 
Object structure the (extrinsic) states of many "virtual" objects (actually, a one and single concrete object). 
This way, the virtual pseudo-objects have to manage only the unchangeable common behavior (intrinsic states). 
These extrinsic states are managed externally, by Client Objects, and passed to the method of the pseudo-object 
when it is called. All virtual objects are controlled in the same way (the behavior is exactly the same) and 
they can not behave independently from one another (as they all refer to one single and same concrete instance).
For guaranteeing one only instance of every flyWeight object, a Singleton Factory can be implemented, and final
Clients can get the number of flyWeights they want based on a few really existing concrete instantiations. Only
the first of each flyWeight type is created as an instance, the rest, of the same type, are multiple references
to one same flyWeight object. The extrinsic states are managed outside and passed to the flyWeight through method
calls (using each reference), and the intrinsic states (common for all the pseudo-objects of that concrete and 
single instance) are maintained inside the single flyWeight concrete object. Most of the states, though, should
be extrinsic, not mentioning the big resources economy provided by the Singleton Factoring of each flyWeight type.

In this example, there are three types of similar FlyWeight classes, each of which maintains the intrinsic states
(a JLable with a resized Icon image), common for all flyWeights of that corresponding instance type. The common 
method (or operation) for the FlyWeight interface is display(MyFrameInterface frame), and the frame (along with 
all its internal objects and states) is the extrinsic state, passed to the flyWeight pseudo-objects at each display 
method call. In this case, this extrinsic state, the frame, is exclusive for every pseudo-object 3-type combination, 
one frame for each. Although it could also be a common state (one single frame) for all of them. 
For Swing, one common frame for hundreds of flyWeights, though, wouldn't end up in any good presentation, because 
the JVM detects when the pseudo-objects are from one same and unique instance, and does not add in multiplicity... 
adding only one for each instance type... although, in other systems, or frameworks, multiple hundreds of one same 
type could be added to the same view, using Patterns like this... with minimal memory taking. Likewise, also because 
of Swing, when one same object (JLabel) instance is used in multiple pseudo-objects (references), and added to multiple 
frames, only the last frame retains the visual representation of the GUI components after updating the view, and, so, 
all other frames turn out blank. Which actually proves, visually, that one same instance has been used and not multiple 
different instances (real objects). The final prove of Singleton effect on the flyWeight is when you compare two 
pseudo-objects of one same instance and the result is "equal". For contrasting, a program that would not use the 
FlyWeight Pattern, would have a different behavior. At the Main class there is the pre-written code for using real 
objects instead of flyWeight references (please uncomment that part of the code and comment the creation through the 
FlyWeight Factories, and run).  The difference is obvious, as, when real objects are used for the multiple same appearance 
GUI components, either in one same frame or in multiple frames, all components DO appear where they should, because they 
are all independent objects referenced by independent references. But it turns out that much more RAM memory is taken 
when you have a great number of these independent instances, either in one or multiple frames (try changing the number 
of iterations to 1000 or more). The final proof, in this case, for the fact that the FlyWeight Pattern has NOT been used 
is the NOT EQUAL result for the comparison between two same type references (JLabels), differently from when FlyWeight 
Pattern is followed.

"Use sharing to support large numbers of fine-grained objects efficiently."
(Design Patterns: Elements of Reusable Object-Oriented Software, 1994)
*/
