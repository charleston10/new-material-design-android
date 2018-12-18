package br.com.charleston.doghero.data.repository

interface Mapper<E, T> {
    fun transform(entity: E): T
}