/*    */ package de.fmstudio.dev.dota_shop.PermissionInterface;
/*    */ 
/*    */ import com.orange451.UltimateArena.UltimateArena;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class PermissionInterface
/*    */ {
/*    */   public static UltimateArena arena;
/*    */ 
/*    */   public static boolean checkPermission(Player player, String command)
/*    */   {
/*    */     try
/*    */     {
/* 13 */       return (player.isOp()) || (player.hasPermission(command)) || (arena.isUaAdmin(player));
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/*    */ 
/* 20 */     return true;
/*    */   }
/*    */ 
/*    */   public static void Initialize(UltimateArena a) {
/* 24 */     arena = a;
/*    */   }
/*    */ }

/* Location:           D:\Minecraft Server\plugins\UltimateArena.jar
 * Qualified Name:     com.orange451.UltimateArena.PermissionInterface.PermissionInterface
 * JD-Core Version:    0.6.0
 */