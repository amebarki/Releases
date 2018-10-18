package com.manga.mebaad.mangarelease.base.fragment

import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {
    protected abstract fun overwriteToolbar()
}