/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.main.ais;

import de.zray.se.SEActor;
import de.zray.se.SEWorld;
import de.zray.se.ai.SEAI;
import de.zray.se.ai.SEAIWorld;
import javax.vecmath.Vector3d;

/**
 *
 * @author Vortex Acherontic
 */
public class AILycan extends SEAI{
    private Vector3d dest;
    private  Vector3d move;
    
    public AILycan(SEWorld world, SEActor actor, SEAIWorld aiMod) {
        super(world, actor, aiMod);
        newDest(parrentActor.getRootMesh().getOrientation().getPositionVec());
    }

    @Override
    public void act(double delta) {
        Vector3d pos = parrentActor.getRootMesh().getOrientation().getPositionVec();
        if(move.x > 0){
            if(dest.x <= parrentActor.getRootMesh().getOrientation().getPositionVec().x){
                if(move.y > 0){
                   if(dest.y <= parrentActor.getRootMesh().getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parrentActor.getRootMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parrentActor.getRootMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                    } 
                }
                else{
                    if(dest.y >= parrentActor.getRootMesh().getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parrentActor.getRootMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parrentActor.getRootMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                    } 
                }
            }
        }
        else{
            if(dest.x >= parrentActor.getRootMesh().getOrientation().getPositionVec().x){
                if(move.y > 0){
                   if(dest.y <= parrentActor.getRootMesh().getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parrentActor.getRootMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parrentActor.getRootMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                    } 
                }
                else{
                    if(dest.y >= parrentActor.getRootMesh().getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parrentActor.getRootMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parrentActor.getRootMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                    } 
                }
            }
        }
        pos.x += move.x*1*delta;
        pos.y += move.y*1*delta;
        pos.z += move.z*1*delta;
        parrentActor.getRootMesh().getOrientation().setPosition(pos.x, pos.y, pos.z);
    }
    
    private void newDest(Vector3d pos){
        dest = new Vector3d(100f*(float)Math.random(), 100f*(float)Math.random(), 100f*(float)Math.random());
        double x = dest.x - pos.x;
        double y = dest.y - pos.y;
        double z = dest.z - pos.z; 
        move = new Vector3d(x, y, z);
        move.normalize();
    }
}
