package com.orcchg.direcall.feature.github_user_profile.impl.data.convert

import com.orcchg.direcall.feature.github_user_profile.api.model.GithubEvent
import com.orcchg.direcall.feature.github_user_profile.impl.model.data.GithubEventEntity
import com.orcchg.direcall.util.Converter
import javax.inject.Inject

class GithubEventCloudConverter @Inject constructor() : Converter<GithubEventEntity, GithubEvent> {

    override fun convert(from: GithubEventEntity): GithubEvent =
        GithubEvent(
            id = from.id,
            type = from.type
        )
}
