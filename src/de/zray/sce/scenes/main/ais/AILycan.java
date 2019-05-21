/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.main.ais;

import de.zray.se.world.Actor;
import de.zray.se.world.World;
import de.zray.se.ai.SEAI;
import de.zray.se.ai.SEAIWorld;
import org.joml.Vector3d;

/**
 *
 * @author Vortex Acherontic
 */
public class AILycan extends SEAI{
    private Vector3d dest;
    private Vector3d move;
    private float speed = 1;
    
    public AILycan(World world, Actor actor, SEAIWorld aiMod) {
        super(world, actor, aiMod);
        newDest(parentActor.getOrientation().getPositionVec());
    }

    @Override
    public void act(double delta) {
        Vector3d pos = parentActor.getOrientation().getPositionVec();
        if(move.x > 0){
            if(dest.x <= parentActor.getOrientation().getPositionVec().x){
                if(move.y > 0){
                   if(dest.y <= parentActor.getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parentActor.getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parentActor.getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                    } 
                }
                else{
                    if(dest.y >= parentActor.getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parentActor.getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parentActor.getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                    } 
                }
            }
        }
        else{
            if(dest.x >= parentActor.getOrientation().getPositionVec().x){
                if(move.y > 0){
                   if(dest.y <= parentActor.getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parentActor.getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parentActor.getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                    } 
                }
                else{
                    if(dest.y >= parentActor.getOrientation().getPositionVec().y){
                        if(move.z > 0){
                            if(dest.z <= parentActor.getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                        else{
                            if(dest.z >= parentActor.getOrientation().getPositionVec().z){
                                newDest(pos);
                            }
                        }
                    } 
                }
            }
        }
        pos.x += move.x*speed*delta;
        pos.y += move.y*speed*delta;
        pos.z += move.z*speed*delta;
        parentActor.getOrientation().setPosition(pos.x, pos.y, pos.z);
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
