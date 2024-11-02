package io.github.joaogouveia89.tikodog.core.ktx

fun String.humanized() = replaceFirstChar { char -> char.uppercase() }