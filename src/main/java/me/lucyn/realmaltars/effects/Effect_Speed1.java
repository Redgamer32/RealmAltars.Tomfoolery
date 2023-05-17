package me.lucyn.realmaltars.effects;

import me.lucyn.realmaltars.RealmAltars;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Effect_Speed1 extends BaseBlessing {
    private final RealmAltars plugin;
    public Effect_Speed1(RealmAltars plugin) {
        super("Speed1", "Speed", 1);
        this.plugin = plugin;
    }

    /*@EventHandler
    public void resurrection(EntityResurrectEvent respawn,PlayerEvent event){
        if(!plugin.effectList.containsKey(event.getPlayer().getName())) return;
        if(plugin.effectList.get(event.getPlayer().getName()) == this.name) {
            if (respawn.isCancelled()==true||respawn.getEntity()!=event.getPlayer()){return;}
            applyEffect(event);
        }
    }To do*/

    @EventHandler
    public void login(PlayerJoinEvent event){
        if(!plugin.effectList.containsKey(event.getPlayer().getName())) return;
        if(plugin.effectList.get(event.getPlayer().getName()) == this.name) {
            applyEffect(event);
        }
    }
    @EventHandler
    public void death(PlayerRespawnEvent event){
        if(!plugin.effectList.containsKey(event.getPlayer().getName())) return;
        if(plugin.effectList.get(event.getPlayer().getName()) == this.name) {
            applyEffect(event);
        }
    }
    @EventHandler
    public void milk(PlayerItemConsumeEvent event){
            if(!plugin.effectList.containsKey(event.getPlayer().getName())) return;
            if(plugin.effectList.get(event.getPlayer().getName()) == this.name) {
                if (event.getItem().getType()!= Material.MILK_BUCKET) {return;}
                applyEffect(event);
            }
    }

    private void applyEffect(PlayerEvent event) {
        event.getPlayer().removePotionEffect(PotionEffectType.SPEED);
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0, true, true, false));
    }
}
