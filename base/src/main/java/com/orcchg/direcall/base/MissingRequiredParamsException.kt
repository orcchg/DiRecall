package com.orcchg.direcall.base

import java.lang.RuntimeException

class MissingRequiredParamsException(msg: String?) : RuntimeException(msg)
