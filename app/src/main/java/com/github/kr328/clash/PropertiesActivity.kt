package com.github.kr328.clash

import com.github.kr328.clash.common.util.intent
import com.github.kr328.clash.common.util.setUUID
import com.github.kr328.clash.common.util.uuid
import com.github.kr328.clash.design.PropertiesDesign
import com.github.kr328.clash.design.ui.ToastDuration
import com.github.kr328.clash.design.util.showExceptionToast
import com.github.kr328.clash.service.model.Profile
import com.github.kr328.clash.util.withProfile
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select
import com.github.kr328.clash.design.R

class PropertiesActivity : BaseActivity<PropertiesDesign>() {
    override suspend fun main() {
        // Redirect to main activity since we're removing profile editing
        finish()
        startActivity(intent<MainActivity>())
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}