
interface PunchBehaviour{
    public void punch();
}

class CommonPunch implements PunchBehaviour{
    public void punch(){
        System.out.println("CommonPunch");
    }
}

class EmptyPunch implements PunchBehaviour{
    public void punch(){
        // throw an exception
    }
}

class VajraPunch implements PunchBehaviour{
    public void punch(){
        System.out.println("VajraPunch");
    }
}

interface JumpBehaviour{
    public void jump();
}

class TornadoJump implements JumpBehaviour{
    public void jump(){
        System.out.println("TornadoJump");
    }
}

class CommonJump implements JumpBehaviour{
    public void jump(){
        System.out.println("CommonJump");
    }
}

interface JumpKickBehaviour{
    public void jumpkick();
}

class CommonJumpKick implements JumpKickBehaviour{
    public void jumpkick(){
        System.out.println("CommonJumpKick");
    }
}

class NinjaPunch implements PunchBehaviour{
    public void punch(){
        System.out.println("NinjaPunch");
    }
}

abstract class Fighter{
    private PunchBehaviour pb;
    private JumpBehaviour jb;
    private JumpKickBehaviour jkb;

    public Fighter(PunchBehaviour _pb, JumpBehaviour _jb,
    JumpKickBehaviour _jkb){
        pb = _pb;
        jb = _jb;
        jkb = _jkb;
    }

    public void Kick(){
        // common kick behavior for all fighters
        System.out.println("Kicked by Fighter");
    }

    public void Punch() {
        //System.out.println("Punched by Fighter");
        pb.punch();
    }

    public void Jump() {
        //System.out.println("Jumped by Fighter");
        jb.jump();
    }
    
    public void JumpKick() {
        //System.out.println("JumpKicked by Fighter");
        jkb.jumpkick();
    }

    public void Sound() {
        // System.out.println("Sounded by Fighter");
        // throw exception
    }
}

//void callFunc(Ninja n){}
//void callFunc(Hanuman n){}
//void callFunc(Fighter n){}

class Ninja extends Fighter{ // will create object of fighter class
    public Ninja(PunchBehaviour _pb, JumpBehaviour _jb,
    JumpKickBehaviour _jkb){
        super(_pb, _jb, _jkb);
    }

    public void Sound() {
        System.out.println("Sounded by Ninja");
    }
}

class KungfuPanda extends Fighter{ // will create object of fighter class
    public KungfuPanda(PunchBehaviour _pb, JumpBehaviour _jb,
    JumpKickBehaviour _jkb){
        super(_pb, _jb, _jkb);
    }

    public void Sound() {
        System.out.println("Sounded by KungfuPanda");
    }
}

class Hanuman extends Fighter{
    public Hanuman(PunchBehaviour _pb, JumpBehaviour _jb,
    JumpKickBehaviour _jkb){
        super(_pb, _jb, _jkb);
    }

    public void Sound() {
        System.out.println("Sounded by Hanuman");
    }
}


public class Gamer{
    public static void main(String[] args){
        JumpBehaviour jb1 = new TornadoJump();
        PunchBehaviour pb1 = new NinjaPunch();
        JumpKickBehaviour jkb1 = new CommonJumpKick();

        Ninja n = new Ninja(pb1, jb1, jkb1);

        n.Kick();
        n.Punch();
        n.Jump();
        n.JumpKick();
        n.Sound();

        JumpBehaviour jb2 = new CommonJump();
        PunchBehaviour pb2 = new VajraPunch();
        JumpKickBehaviour jkb2 = new CommonJumpKick();

        Hanuman h = new Hanuman(pb2, jb2, jkb2);
        h.Kick();
        h.Punch();
        h.Jump();
        h.JumpKick();
        h.Sound();
    }
}