/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.main.ais;

import de.zray.se.SEActor;
import de.zray.se.SEWorld;
import de.zray.se.ai.SEAI;
import de.zray.se.ai.SEAIModule;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author Vortex Acherontic
 */
public class AILycan extends SEAI{
    private Vector3f dest;
    private  Vector3f move;
    
    public AILycan(SEWorld world, SEActor actor, SEAIModule aiMod) {
        super(world, actor, aiMod);
        newDest(parrentActor.getSEMesh().getOrientation().getPositionVec());
    }

    @Override
    public void act(float delta) {
        Vector3f pos = parrentActor.getSEMesh().getOrientation().getPositionVec();
        if(move.x > 0){
            if(dest.x <= parrentActor.getSEMesh().getOrientation().getPositionVec().x){
                if(move.y > 0){
                   if(dest.y <= parrentActor.getSEMesh().getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parrentActor.getSEMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parrentActor.getSEMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                    } 
                }
                else{
                    if(dest.y >= parrentActor.getSEMesh().getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parrentActor.getSEMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parrentActor.getSEMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                    } 
                }
            }
        }
        else{
            if(dest.x >= parrentActor.getSEMesh().getOrientation().getPositionVec().x){
                if(move.y > 0){
                   if(dest.y <= parrentActor.getSEMesh().getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parrentActor.getSEMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parrentActor.getSEMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                    } 
                }
                else{
                    if(dest.y >= parrentActor.getSEMesh().getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parrentActor.getSEMesh().getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parrentActor.getSEMesh().getOrientation().getPositionVec().z){
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
        parrentActor.getSEMesh().getOrientation().setPosition(pos.x, pos.y, pos.z);
    }
    
    private void newDest(Vector3f pos){
        dest = new Vector3f(100f*(float)Math.random(), 100f*(float)Math.random(), 100f*(float)Math.random());
        float x = dest.x - pos.x;
        float y = dest.y - pos.y;
        float z = dest.z - pos.z; 
        move = new Vector3f(x, y, z);
        move.normalise();
    }
}
