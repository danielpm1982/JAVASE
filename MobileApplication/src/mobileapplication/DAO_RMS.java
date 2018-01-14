/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Vector;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

/**
 *
 * @author Daniel
 */
public class DAO_RMS {
    private RecordStore recordStore;
    private static final String DB_CLIENT = "db_client";
    
    public boolean openDB(boolean create){
        try{
            this.recordStore=RecordStore.openRecordStore(DB_CLIENT, create);
            return true;
        } catch(RecordStoreException ex){
            return false;
        }
    }
    
    public boolean closeDB(){
        try{
            this.recordStore.closeRecordStore();
            return true;
        } catch (RecordStoreException ex){
            return false;
        }
    }
    
    public boolean deleteDB(){
        try{
            RecordStore.deleteRecordStore(DB_CLIENT);
            return true;
        } catch (RecordStoreException ex){
            return false;
        }
    }
    
    public boolean addRegistry(String key, String name){
        try{
            this.recordStore=RecordStore.openRecordStore(DB_CLIENT, true);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bao);
            dos.writeUTF(key);
            dos.writeUTF(name);
            byte[] registry = bao.toByteArray();
            this.recordStore.addRecord(registry, 0, registry.length);
            dos.close();
            bao.close();
            return true;
        } catch (Exception ex){
            return false;
        } finally {
            try{
                if (this.recordStore!=null){
                    this.recordStore.closeRecordStore();
                }
            } catch (Exception ex){
            }
        }
    }
    
    public boolean setRegistry(int id, String key, String name){
        try{
            this.recordStore=RecordStore.openRecordStore(DB_CLIENT, true);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bao);
            dos.writeUTF(key);
            dos.writeUTF(name);
            byte[] registry = bao.toByteArray();
            this.recordStore.setRecord(id, registry, 0, registry.length);
            dos.close();
            bao.close();
            return true;
        } catch (Exception ex){
            return false;
        } finally {
            try{
                if (this.recordStore!=null){
                    this.recordStore.closeRecordStore();
                }
            } catch (Exception ex){
            }
        }
    }
    
    public Client readRegistry(int id){
        Client client = null;
        try{
            this.recordStore=RecordStore.openRecordStore(DB_CLIENT, true);
            byte[] registry = this.recordStore.getRecord(id);
            if(registry!=null){
                ByteArrayInputStream bai = new ByteArrayInputStream(registry);
                DataInputStream dis = new DataInputStream(bai);
                client = new Client();
                client.setId(id);
                client.setKey(dis.readUTF());
                client.setName(dis.readUTF());
                dis.close();
                bai.close();
            }
        } catch (Exception ex){
        } finally {
            try{
                if(this.recordStore!=null){
                    this.recordStore.closeRecordStore();
                }
            } catch (Exception ex){
            }
        }
        return client;
    }
    
    public boolean deleteRegistry(int id){
        try{
            this.recordStore=RecordStore.openRecordStore(DB_CLIENT, true);
            this.recordStore.deleteRecord(id);
            return true;
        } catch (Exception ex){
        } finally {
            try{
                if (this.recordStore!=null){
                    this.recordStore.closeRecordStore();
                }
            } catch (Exception ex) {
            }
        }
        return true;
    }
    
    public int numberOfRegistries(){
        int numRegistries=0;
        try{
            RecordEnumeration registryEnum = this.recordStore.enumerateRecords(null, null, true);
            numRegistries = registryEnum.numRecords();
        } catch (Exception ex){
        } finally {
            try{
                if (this.recordStore!=null){
                this.recordStore.closeRecordStore();
                }
            } catch (Exception ex){
            }
        }
        return numRegistries;
    }
    
    public Vector getAllRegistries(){
        Client client = null;
        byte[] registry = null;
        Vector clientsVector = new Vector(50);
        try{
            this.recordStore=RecordStore.openRecordStore(DB_CLIENT, true);
            RecordEnumeration registryEnum = this.recordStore.enumerateRecords(null, null, false);
            while (registryEnum.hasNextElement()){
                //int id = registryEnum.nextRecordId();
                registry = registryEnum.nextRecord();
                ByteArrayInputStream bai = new ByteArrayInputStream(registry);
                DataInputStream dis = new DataInputStream(bai);
                client = new Client();
                //client.setId(id);
                client.setKey(dis.readUTF());
                client.setName(dis.readUTF());
                dis.close();
                bai.close();
                clientsVector.addElement(client);
            }
        } catch (Exception ex){
        } finally {
            try{
                if (this.recordStore!=null){
                this.recordStore.closeRecordStore();
                } 
            } catch (Exception ex){
            }
        }
        return clientsVector;
    }
}
