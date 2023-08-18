package com.looker.core.data.fdroid.sync

import com.looker.core.model.newer.Repo
import org.fdroid.index.v1.IndexV1
import org.fdroid.index.v2.Entry
import org.fdroid.index.v2.IndexV2

interface IndexDownloader {

	suspend fun downloadIndexV1(repo: Repo): IndexV1

	suspend fun downloadIndexV2(repo: Repo): IndexV2

	suspend fun downloadIndexDiff(repo: Repo, name: String): IndexV2

	suspend fun downloadEntry(repo: Repo): Entry

	suspend fun determineIndexType(repo: Repo): IndexType

}

fun Repo.indexUrl(parameter: String): String =
	buildString {
		append(address.removeSuffix("/"))
		append("/")
		append(parameter.removePrefix("/"))
	}