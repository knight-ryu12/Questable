package net.fumyatan.questable.Hooker;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import net.fumyatan.questable.Questable;

public class WorldGuardHooker {

	public static List<String> getRegion(Location loc, Player target){
		ApplicableRegionSet ars =  Questable.worldguard.getRegionManager(loc.getWorld()).getApplicableRegions(loc);
		List<String> regions = new ArrayList<>();

		for (ProtectedRegion info : ars.getRegions()){
			regions.add(info.getId());
		}
		return regions;
	}

	public static boolean checkOwner(Player target, String region){
		LocalPlayer player = Questable.worldguard.wrapPlayer(target);
		boolean owner = Questable.worldguard.getRegionManager(target.getWorld()).getRegion(region).isOwner(player);
		boolean member = Questable.worldguard.getRegionManager(target.getWorld()).getRegion(region).isMember(player);
		if (owner || member){
			return true;
		} else {
			return false;
		}
	}

	public static void setOwner(Player target, String region){
		DefaultDomain domain = new DefaultDomain();
		domain.addPlayer(target.getName());
		Questable.worldguard.getRegionManager(target.getWorld()).getRegion(region).setOwners(domain);
	}

}
