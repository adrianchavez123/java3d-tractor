/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package x;

import com.sun.j3d.loaders.IncorrectFormatException;
import com.sun.j3d.loaders.ParsingErrorException;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.image.TextureLoader;
import java.awt.Container;
import java.io.FileNotFoundException;
import javax.media.j3d.Alpha;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.Group;
import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.Material;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Texture;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TransparencyAttributes;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author adrian
 */
public class Figura3D {

    public BranchGroup rootGroup;
    private BoundingSphere bounds;
    //public TransformGroup conoRotado = new TransformGroup();
    public TransformGroup TodoRotado = new TransformGroup();
    public TransformGroup cajaRotada = new TransformGroup();
    public TransformGroup cilindroRotado = new TransformGroup();
    public TransformGroup rotarLlanta1 = new TransformGroup();
    public TransformGroup rotarLlanta2 = new TransformGroup();
    public TransformGroup rotarLlanta3 = new TransformGroup();
    public TransformGroup rotarLlanta4 = new TransformGroup();
    public TransformGroup rotarPizo = new TransformGroup();
    public TransformGroup rotarTecho = new TransformGroup();
    public TransformGroup c1 = new TransformGroup();
    public TransformGroup c2 = new TransformGroup();
    public TransformGroup c3 = new TransformGroup();
    public TransformGroup c4 = new TransformGroup();
    public TransformGroup rotarVolante = new TransformGroup();
    public TransformGroup rotarCristal = new TransformGroup();
    
    Transform3D transTodo=new Transform3D();
         Transform3D transTodo2=new Transform3D();
        TransformGroup objSpin = new TransformGroup();

    public Group todo = new Group();

    public Figura3D()
    {
        rootGroup = new BranchGroup();
        bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),100.0);
        crearPlataforma();
    }

    public void crearPlataforma()
    {
        //cono
       /* Transform3D rotcono = new Transform3D();
        Transform3D transcono = new Transform3D();
        Appearance appear = new Appearance();

        //girar en base coordenadas
        transcono.setTranslation(new Vector3d(0.3f,0.0f,0.0f));
        rotcono.rotZ(Math.PI/180*0);
        transcono.mul(rotcono);

       // girar en base zy
//         rotate.rotZ(Math.PI/12.0);
//    tempRotate.rotY(Math.PI/7.0);
//    rotate.mul(tempRotate);

        Cone cone1 = new Cone(0.2f, 0.4f);
        cone1.setAppearance(appear);
        conoRotado.setTransform(transcono);
        conoRotado.addChild(cone1);

        todo.addChild(conoRotado);
        */

        Transform3D rotcaja = new Transform3D();
        Transform3D transcono = new Transform3D();
        Appearance appear = new Appearance();

       /* Color3f color = new Color3f (1.0f, 0.0f, 0.0f);
        ColoringAttributes colorA = new ColoringAttributes (color, 1);
        appear.setColoringAttributes(colorA);*/
        //girar en base coordenadas
        transcono.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
        rotcaja.rotZ(Math.PI/180*0);
        transcono.mul(rotcaja);


        int paratextura = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        TextureLoader loader=null;
        Texture texture=null;


        loader = new TextureLoader("metal.png","INTENSITY", new Container());
        texture = loader.getTexture();
        appear = new Appearance();
        appear.setTexture(texture);

        int paratextura2 = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        TextureLoader loader2=null;
        Texture texture2=null;
        Appearance a = null;

        loader2 = new TextureLoader("metal_azul.png","INTENSITY", new Container());
        texture2 = loader2.getTexture();
        a = new Appearance();
        a.setTexture(texture2);
        a.setMaterial(new Material());
       // Cone cone1 = new Cone(0.2f, 0.4f);
        
        Box caja = new Box(0.2f,0.1f,0.1f,paratextura2,a);
        
        //Box caja = new Box(0.2f,0.1f,0.1f,Box.GENERATE_NORMALS,ap);
        //caja.setAppearance(appear);
        cajaRotada.setTransform(transcono);
        cajaRotada.addChild(caja);

        //chimenea
        Transform3D rotcilindro = new Transform3D();
        Transform3D transilindro = new Transform3D();
        Appearance appear2 = new Appearance();

        Color3f color2 = new Color3f (0.8f, 0.8f, 0.8f);
        ColoringAttributes colorA2 = new ColoringAttributes (color2, 1);
        appear2.setColoringAttributes(colorA2);
        appear2.setMaterial(new Material());
        //girar en base coordenadas
        transilindro.setTranslation(new Vector3d(0.11f,0.15f,0.0f));
        rotcilindro.rotZ(Math.PI/180*0);
        transilindro.mul(rotcaja);



       // Cone cone1 = new Cone(0.2f, 0.4f);
        Cylinder cilindro = new Cylinder(0.02f,0.09f,Cylinder.GENERATE_NORMALS,appear2);
        //caja.setAppearance(appear);
        cilindroRotado.setTransform(transilindro);
        cilindroRotado.addChild(cilindro);


        //llanta tracera

        Transform3D rotllanta1 = new Transform3D();
        Transform3D transllanta1 = new Transform3D();
        Appearance appear3 = new Appearance();

        int paratextura3 = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        TextureLoader loader3=null;
        Texture texture3=null;


        loader3 = new TextureLoader("rines.png","INTENSITY", new Container());
        texture3 = loader3.getTexture();
        //a = new Appearance();
        appear3.setTexture(texture3);
        appear3.setMaterial(new Material());
        //Color3f color3 = new Color3f (0.8f, 0.8f, 0.8f);
        //ColoringAttributes colorA3 = new ColoringAttributes (color3, 1);
        //appear3.setColoringAttributes(colorA3);
        //girar en base coordenadas
        transllanta1.setTranslation(new Vector3d(-0.39f,-0.15f,0.13f));
        rotllanta1.rotX(Math.PI/180*90);
        transllanta1.mul(rotllanta1);



       // Cone cone1 = new Cone(0.2f, 0.4f);
        Cylinder llanta1 = new Cylinder(0.2f,0.06f,paratextura3,appear3);
        //caja.setAppearance(appear);
        rotarLlanta1.setTransform(transllanta1);
        rotarLlanta1.addChild(llanta1);

        //llanta tracera

        Transform3D rotllanta2 = new Transform3D();
        Transform3D transllanta2 = new Transform3D();

        //girar en base coordenadas
        transllanta2.setTranslation(new Vector3d(-0.39f,-0.15f,-0.13f));
        rotllanta2.rotX(Math.PI/180*90);
        transllanta2.mul(rotllanta2);



       // Cone cone1 = new Cone(0.2f, 0.4f);
        Cylinder llanta2 = new Cylinder(0.2f,0.06f,paratextura3,appear3);
        //caja.setAppearance(appear);
        rotarLlanta2.setTransform(transllanta2);
        rotarLlanta2.addChild(llanta2);


//        //llanta tracera
//
//        Transform3D rotllanta1 = new Transform3D();
//        Transform3D transllanta1 = new Transform3D();
//        Appearance appear3 = new Appearance();
//
//        Color3f color3 = new Color3f (0.8f, 0.8f, 0.8f);
//        ColoringAttributes colorA3 = new ColoringAttributes (color3, 1);
//        appear3.setColoringAttributes(colorA3);
//        //girar en base coordenadas
//        transllanta1.setTranslation(new Vector3d(-0.39f,-0.15f,0.13f));
//        rotllanta1.rotX(Math.PI/180*90);
//        transllanta1.mul(rotllanta1);
//
//
//
//       // Cone cone1 = new Cone(0.2f, 0.4f);
//        Cylinder llanta1 = new Cylinder(0.2f,0.06f,appear2);
//        //caja.setAppearance(appear);
//        rotarLlanta1.setTransform(transllanta1);
//        rotarLlanta1.addChild(llanta1);

        //llanta delantera

        Transform3D rotllanta3 = new Transform3D();
        Transform3D transllanta3 = new Transform3D();

        //girar en base coordenadas
        transllanta3.setTranslation(new Vector3d(0.15f,-0.25f,-0.13f));
        rotllanta3.rotX(Math.PI/180*90);
        transllanta3.mul(rotllanta3);



       // Cone cone1 = new Cone(0.2f, 0.4f);
        Cylinder llanta3 = new Cylinder(0.1f,0.06f,paratextura3,appear3);
        //caja.setAppearance(appear);
        rotarLlanta3.setTransform(transllanta3);
        rotarLlanta3.addChild(llanta3);

        //llanta delantera

        Transform3D rotllanta4 = new Transform3D();
        Transform3D transllanta4 = new Transform3D();

        //girar en base coordenadas
        transllanta4.setTranslation(new Vector3d(0.15f,-0.25f,0.13f));
        rotllanta4.rotX(Math.PI/180*90);
        transllanta4.mul(rotllanta4);



       // Cone cone1 = new Cone(0.2f, 0.4f);
        Cylinder llanta4 = new Cylinder(0.1f,0.06f,paratextura3,appear3);
        //caja.setAppearance(appear);
        rotarLlanta4.setTransform(transllanta4);
        rotarLlanta4.addChild(llanta4);


        Transform3D rotpizo = new Transform3D();
        Transform3D transpizo = new Transform3D();

        //girar en base coordenadas
        transpizo.setTranslation(new Vector3d(-0.2f,-0.09f,0.0f));
        rotpizo.rotZ(Math.PI/180*0);
        transpizo.mul(rotpizo);

         Appearance appea = new Appearance();
        appea.setMaterial(new Material());
        
        Color3f colo = new Color3f (0.0f, 0.0f, 1.0f);
        ColoringAttributes col = new ColoringAttributes (colo, 1);
        appear3.setColoringAttributes(col);

       // Cone cone1 = new Cone(0.2f, 0.4f);
        Box pizo = new Box(0.15f,0.01f,0.09f,paratextura,appear);
        //caja.setAppearance(appear);
        rotarPizo.setTransform(transpizo);
        rotarPizo.addChild(pizo);


        //cilindro cabina
        Transform3D rotc1=new Transform3D();
        Transform3D transc1=new Transform3D();
        transc1.setTranslation(new Vector3d(-0.2,0.2f,0.08f));
        rotc1.rotZ(Math.PI/180*0);
        transc1.mul(rotc1);

        Cylinder cilin1=new Cylinder(0.02f,0.2f,Cylinder.GENERATE_NORMALS,appea);
        c1.setTransform(transc1);
        c1.addChild(cilin1);

        //cilindro cabina
        Transform3D rotc2=new Transform3D();
        Transform3D transc2=new Transform3D();
        transc2.setTranslation(new Vector3d(-0.2,0.2f,-0.08f));
        rotc2.rotZ(Math.PI/180*0);
        transc2.mul(rotc2);

        Cylinder cilin2=new Cylinder(0.02f,0.2f,appea);
        c2.setTransform(transc2);
        c2.addChild(cilin2);

        //cilindro cabina
        Transform3D rotc3=new Transform3D();
        Transform3D transc3=new Transform3D();
        transc3.setTranslation(new Vector3d(-0.35,0.1f,0.08f));
        rotc3.rotZ(Math.PI/180*0);
        transc1.mul(rotc1);

        Cylinder cilin3=new Cylinder(0.02f,0.4f,appea);
        c3.setTransform(transc3);
        c3.addChild(cilin3);

        //cilindro cabina
        Transform3D rotc4=new Transform3D();
        Transform3D transc4=new Transform3D();
        transc4.setTranslation(new Vector3d(-0.35,0.1f,-0.08f));
        rotc4.rotZ(Math.PI/180*0);
        transc4.mul(rotc1);

        Cylinder cilin4=new Cylinder(0.02f,0.4f,appea);
        c4.setTransform(transc4);
        c4.addChild(cilin4);

        Transform3D rottecho = new Transform3D();
        Transform3D transtecho = new Transform3D();

        //girar en base coordenadas
        transtecho.setTranslation(new Vector3d(-0.25f,0.3f,0.0f));
        rottecho.rotZ(Math.PI/180*0);
        transtecho.mul(rottecho);

         Appearance app = new Appearance();
        Color3f color5 = new Color3f (0.0f, 0.0f, 1.0f);
        ColoringAttributes colorA5 = new ColoringAttributes (color5, 1);
        app.setColoringAttributes(colorA5);

       // Cone cone1 = new Cone(0.2f, 0.4f);
        Box techo = new Box(0.15f,0.01f,0.09f,paratextura,appear);
        //caja.setAppearance(appear);
        rotarTecho.setTransform(transtecho);
        rotarTecho.addChild(techo);

        //llanta delantera

        Transform3D rotvolante = new Transform3D();
        Transform3D transvolante = new Transform3D();

        //girar en base coordenadas
        transvolante.setTranslation(new Vector3d(-0.22f,0.1f,0.f));
        rotvolante.rotZ(Math.PI/180*90);
        transvolante.mul(rotvolante);

         Appearance app2 = new Appearance();
        Color3f color52 = new Color3f (0.1f, 0.1f, 0.6f);
        ColoringAttributes colorA52 = new ColoringAttributes (color52, 1);
        app2.setColoringAttributes(colorA52);
//
       // Cone cone1 = new Cone(0.2f, 0.4f);
        Cylinder volante = new Cylinder(0.05f,0.03f,app2);
        //caja.setAppearance(appear);
        rotarVolante.setTransform(transvolante);
        rotarVolante.addChild(volante);
        
        
        Transform3D rotcristal = new Transform3D();
        Transform3D trancristal = new Transform3D();

        //girar en base coordenadas
        trancristal.setTranslation(new Vector3d(-0.17f,0.2f,0.0f));
        rotcristal.rotZ(Math.PI/180*90);
        trancristal.mul(rotcristal);

         Appearance appq = new Appearance();
        Color3f c = new Color3f (0.0f, 0.8f, 1.0f);
        ColoringAttributes c5 = new ColoringAttributes (c, 1);
        appq.setColoringAttributes(c5);

        TransparencyAttributes t_attr =new TransparencyAttributes(TransparencyAttributes.BLENDED,0.01f,

                TransparencyAttributes.BLEND_SRC_ALPHA,

                TransparencyAttributes.BLEND_ONE);

        appq.setTransparencyAttributes( t_attr );
       // Cone cone1 = new Cone(0.2f, 0.4f);
        Box cristal = new Box(0.1f,0.005f,0.09f,paratextura,appq);
        //caja.setAppearance(appear);
        rotarCristal.setTransform(trancristal);
        rotarCristal.addChild(cristal);
        

       /* cilindroRotado.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        cilindroRotado.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        cajaRotada.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        cajaRotada.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);*/

        rotarLlanta1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        rotarLlanta1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        rotarLlanta2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        rotarLlanta2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        rotarLlanta3.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        rotarLlanta3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        rotarLlanta4.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        rotarLlanta4.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        todo.addChild(cajaRotada);
        todo.addChild(cilindroRotado);
        todo.addChild(rotarLlanta1);
        todo.addChild(rotarLlanta2);
        todo.addChild(rotarLlanta3);
        todo.addChild(rotarLlanta4);
        todo.addChild(rotarPizo);
        todo.addChild(rotarTecho);
        todo.addChild(c1);
        todo.addChild(c2);
        todo.addChild(c3);
        todo.addChild(c4);
        todo.addChild(rotarVolante);
        todo.addChild(rotarCristal);


         
        objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        transTodo.rotY(Math.PI/180*90);;
        objSpin.addChild(todo);
        
        transTodo2.setTranslation(new Vector3d(-1.5f,0.0f,0.0f));
        transTodo.mul(transTodo2);
        objSpin.setTransform(transTodo);
        
       /* Transform3D rotTodo=new Transform3D();
        Transform3D transTodo=new Transform3D();
        TransformGroup objSpin = new TransformGroup();
        objSpin.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        transTodo.setTranslation(new Vector3d(0.0f,0.0f,0.0f));
        rotTodo.rotZ(Math.PI/180*0);
        transTodo.mul(rotTodo);

        TodoRotado.setTransform(transTodo);

        objSpin.addChild(todo);

        Transform3D yAxis = new Transform3D();
        yAxis.rotY(Math.PI/180*90);
        Alpha rotationAlpha = new Alpha(-1, 10000);
        RotationInterpolator rotator =new RotationInterpolator(rotationAlpha, objSpin, yAxis,0.0f, (float) Math.PI*2.0f);
        objSpin.addChild(rotator);

         TodoRotado.addChild(objSpin);
         rotator.setSchedulingBounds(bounds);
        rootGroup.addChild(TodoRotado);*/
        
         DirectionalLight lightD1 = new DirectionalLight();
     lightD1.setInfluencingBounds(bounds);
     lightD1.setDirection(0.0f, 0.0f, -1.0f);
     Color3f azul = new Color3f(0.3f,0.3f,0.8f);
     lightD1.setColor(azul);
     
    rootGroup.addChild(objSpin);
    
    
    
     // customize DirectionalLight object
        rootGroup.addChild(lightD1);
        
    /*    AmbientLight lightA = new AmbientLight();
  lightA.setInfluencingBounds(new BoundingSphere());
  rootGroup.addChild(lightA);*/
 /*       Background backg = new Background(0.8f, 0.8f, 0.8f);
        backg.setApplicationBounds(bounds);
        

   //backg.setApplicationBoundingLeaf(boundingLeaf);
   rootGroup.addChild(backg);
   rootGroup.compile();
*/

        TextureLoader myLoader = new TextureLoader( "carretera.png", new Container() );
ImageComponent2D myImage = myLoader.getImage( );


Background myBack = new Background( );
myBack.setImage( myImage );

BoundingSphere myBounds = new BoundingSphere(new Point3d( ), 1000.0 );
myBack.setApplicationBounds( myBounds );

    rootGroup.addChild(myBack);
    }
}
