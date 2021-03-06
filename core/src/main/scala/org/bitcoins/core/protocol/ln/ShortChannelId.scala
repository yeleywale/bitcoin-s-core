package org.bitcoins.core.protocol.ln

import org.bitcoins.core.number.UInt64
import org.bitcoins.core.protocol.NetworkElement
import org.bitcoins.core.util.Factory
import scodec.bits.ByteVector

case class ShortChannelId(u64: UInt64) extends NetworkElement {
  override def bytes: ByteVector = u64.bytes

  /**
    * Output example:
    * {{{
    * > ShortChannelId.fromHex("db0000010000")
    * ShortChannelId(db0000010000)
    * }}}
    */
  override def toString: String = s"ShortChannelId(${hex.drop(4)})"
}

object ShortChannelId extends Factory[ShortChannelId] {

  override def fromBytes(byteVector: ByteVector): ShortChannelId = {
    new ShortChannelId(UInt64.fromBytes(byteVector))
  }
}
