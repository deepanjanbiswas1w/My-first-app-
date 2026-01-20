package com.khotornak.guard

import android.net.VpnService
import android.os.ParcelFileDescriptor
import android.content.Intent

class KhotornakEngine : VpnService() {
    private var vpnInterface: ParcelFileDescriptor? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val builder = Builder()
            .setSession("Khotornak Shield")
            .addAddress("10.1.1.1", 24)
            .addDnsServer("94.140.14.14") // AdGuard DNS (Modern DoH interface)
            .addDnsServer("2a10:50c0::ad1:ff") // IPv6 AdGuard DNS
            .addRoute("0.0.0.0", 0) 
            .setMtu(1500)
            .setBlocking(true)

        // আধুনিক ফায়ারওয়াল লজিক: ফালতু অ্যাপের ইন্টারনেট কাটা
        // এখানে তুই তোর লজিক অনুযায়ী অ্যাপের প্যাকেজ আইডি দিবি
        val blockedApps = listOf("com.android.vending") 
        blockedApps.forEach { 
            try { builder.addDisallowedApplication(it) } catch (e: Exception) {} 
        }

        vpnInterface = builder.establish()
        return START_STICKY
    }
}
