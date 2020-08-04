package com.stanfit.android.extension.version

/**
 * Version（example 1.0.0）
 *
 * You can compare other version.
 * Version(1.1.0) > Version(1.0.0)
 *
 * @property major major version num.
 * @property minor minor version num.
 * @property patch patch version num.
 */
class Version(val major: Int = 0, val minor: Int = 0, val patch: Int = 0) : Comparable<Version> {

    /**
     * Version（1.0.0）
     */
    private val version = versionOf(major, minor, patch)

    /**
     * Version string to int value.
     *
     * @param major major version num.
     * @param minor minor version num.
     * @param patch patch version num.
     * @return Int
     */
    private fun versionOf(major: Int, minor: Int, patch: Int): Int {
        return major.shl(16) + minor.shl(8) + patch
    }

    override fun toString(): String = "$major.$minor.$patch"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        val otherVersion = (other as? Version) ?: return false
        return this.version == otherVersion.version
    }

    override fun hashCode(): Int = version

    override fun compareTo(other: Version): Int = version - other.version

    companion object {

        /**
         * Generated from the string version.
         *
         * @param version Version（String）
         * @return [Version]
         */
        @Throws(IllegalArgumentException::class, NumberFormatException::class)
        fun from(version: String): Version {
            val parts = version.split(Regex("\\."))
            return when (parts.count()) {
                1 -> Version(parts[0].toInt())
                2 -> Version(parts[0].toInt(), parts[1].toInt())
                3 -> Version(parts[0].toInt(), parts[1].toInt(), parts[2].toInt())
                else -> throw IllegalArgumentException("This is invalid version format. $version")
            }
        }
    }
}
