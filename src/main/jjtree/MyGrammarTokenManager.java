/* MyGrammarTokenManager.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. MyGrammarTokenManager.java */
package main.jjtree;
import java.io.FileReader;
import main.*;

/** Token Manager. */
@SuppressWarnings ("unused")
public class MyGrammarTokenManager implements MyGrammarConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x20000000000L) != 0L)
            return 18;
         if ((active0 & 0x400000L) != 0L)
         {
            jjmatchedKind = 54;
            return 6;
         }
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 54;
            return 2;
         }
         if ((active0 & 0x57fbe0000L) != 0L)
         {
            jjmatchedKind = 54;
            return 9;
         }
         return -1;
      case 1:
         if ((active0 & 0x59ffe0000L) != 0L)
         {
            jjmatchedKind = 54;
            jjmatchedPos = 1;
            return 9;
         }
         if ((active0 & 0x60000000L) != 0L)
            return 9;
         return -1;
      case 2:
         if ((active0 & 0x59afc0000L) != 0L)
         {
            jjmatchedKind = 54;
            jjmatchedPos = 2;
            return 9;
         }
         if ((active0 & 0x5020000L) != 0L)
            return 9;
         return -1;
      case 3:
         if ((active0 & 0x41ae80000L) != 0L)
         {
            jjmatchedKind = 54;
            jjmatchedPos = 3;
            return 9;
         }
         if ((active0 & 0x180140000L) != 0L)
            return 9;
         return -1;
      case 4:
         if ((active0 & 0xe80000L) != 0L)
         {
            jjmatchedKind = 54;
            jjmatchedPos = 4;
            return 9;
         }
         if ((active0 & 0x41a000000L) != 0L)
            return 9;
         return -1;
      case 5:
         if ((active0 & 0xe00000L) != 0L)
         {
            jjmatchedKind = 54;
            jjmatchedPos = 5;
            return 9;
         }
         if ((active0 & 0x80000L) != 0L)
            return 9;
         return -1;
      case 6:
         if ((active0 & 0xc00000L) != 0L)
         {
            jjmatchedKind = 54;
            jjmatchedPos = 6;
            return 9;
         }
         if ((active0 & 0x200000L) != 0L)
            return 9;
         return -1;
      case 7:
         if ((active0 & 0x800000L) != 0L)
         {
            jjmatchedKind = 54;
            jjmatchedPos = 7;
            return 9;
         }
         if ((active0 & 0x400000L) != 0L)
            return 9;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 35;
         return jjMoveStringLiteralDfa1_0(0x800000000000L);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x2000000000L);
      case 39:
         return jjMoveStringLiteralDfa1_0(0x60L);
      case 40:
         return jjStopAtPos(0, 49);
      case 41:
         return jjStopAtPos(0, 50);
      case 42:
         return jjStopAtPos(0, 40);
      case 43:
         return jjStopAtPos(0, 38);
      case 44:
         return jjStopAtPos(0, 51);
      case 45:
         return jjStopAtPos(0, 39);
      case 47:
         return jjStartNfaWithStates_0(0, 41, 18);
      case 58:
         jjmatchedKind = 52;
         return jjMoveStringLiteralDfa1_0(0x1000000000000L);
      case 59:
         return jjStopAtPos(0, 53);
      case 60:
         jjmatchedKind = 42;
         return jjMoveStringLiteralDfa1_0(0x100000000000L);
      case 61:
         return jjMoveStringLiteralDfa1_0(0x400000000000L);
      case 62:
         jjmatchedKind = 43;
         return jjMoveStringLiteralDfa1_0(0x200000000000L);
      case 82:
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x12100000L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x20000000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x104000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x40020000L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x400a00000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x80000000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x1000000L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x8000000L);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x1000000000L);
      default :
         return jjMoveNfa_0(3, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 32:
         return jjMoveStringLiteralDfa2_0(active0, 0x20L);
      case 38:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStopAtPos(1, 37);
         break;
      case 39:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(1, 6);
         break;
      case 61:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStopAtPos(1, 44);
         else if ((active0 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 45);
         else if ((active0 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 46);
         else if ((active0 & 0x800000000000L) != 0L)
            return jjStopAtPos(1, 47);
         else if ((active0 & 0x1000000000000L) != 0L)
            return jjStopAtPos(1, 48);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x202040000L);
      case 102:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(1, 30, 9);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x88000000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x4020000L);
      case 111:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(1, 29, 9);
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x410a00000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000L);
      case 124:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(1, 36);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 39:
         if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(2, 5);
         break;
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000L);
      case 100:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(2, 26, 9);
         break;
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x90000000L);
      case 103:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x408000000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0xb00000L);
      case 114:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(2, 24, 9);
         return jjMoveStringLiteralDfa3_0(active0, 0x80000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x300000000L);
      case 116:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(2, 17, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000L);
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0xc00000L);
      case 101:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(3, 32, 9);
         break;
      case 103:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x2080000L);
      case 108:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(3, 18, 9);
         else if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(3, 20, 9);
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000L);
      case 110:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(3, 31, 9);
         return jjMoveStringLiteralDfa4_0(active0, 0x400000000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(4, 27, 9);
         return jjMoveStringLiteralDfa5_0(active0, 0x800000L);
      case 107:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(4, 28, 9);
         break;
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x200000000L);
      case 110:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(4, 25, 9);
         return jjMoveStringLiteralDfa5_0(active0, 0x80000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x200000L);
      case 116:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(4, 34, 9);
         return jjMoveStringLiteralDfa5_0(active0, 0x400000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x200000L);
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x800000L);
      case 103:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(5, 19, 9);
         break;
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x400000L);
      case 116:
         if ((active0 & 0x200000000L) != 0L)
            return jjStopAtPos(5, 33);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 109:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(6, 21, 9);
         break;
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x400000L);
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x800000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(7, 22, 9);
         break;
      case 114:
         return jjMoveStringLiteralDfa8_0(active0, 0x800000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(8, 23, 9);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 43;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 18:
                  if (curChar == 42)
                     { jjCheckNAddTwoStates(34, 35); }
                  else if (curChar == 47)
                  {
                     if (kind > 9)
                        kind = 9;
                     { jjCheckNAddStates(0, 2); }
                  }
                  if (curChar == 42)
                     { jjCheckNAddTwoStates(24, 25); }
                  else if (curChar == 47)
                  {
                     if (kind > 7)
                        kind = 7;
                     { jjCheckNAddStates(3, 5); }
                  }
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 14)
                        kind = 14;
                     { jjCheckNAddStates(6, 8); }
                  }
                  else if (curChar == 47)
                     { jjAddStates(9, 12); }
                  else if (curChar == 34)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 6:
               case 9:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 54)
                     kind = 54;
                  { jjCheckNAdd(9); }
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 54)
                     kind = 54;
                  { jjCheckNAdd(9); }
                  break;
               case 10:
                  if (curChar == 34)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 11:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 13:
                  if ((0x8400000000L & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 14:
                  if (curChar == 34 && kind > 55)
                     kind = 55;
                  break;
               case 15:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddStates(16, 19); }
                  break;
               case 16:
                  if ((0xff000000000000L & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 17:
                  if (curChar == 47)
                     { jjAddStates(9, 12); }
                  break;
               case 19:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  { jjCheckNAddStates(3, 5); }
                  break;
               case 20:
                  if ((0x2400L & l) != 0L && kind > 7)
                     kind = 7;
                  break;
               case 21:
                  if (curChar == 10 && kind > 7)
                     kind = 7;
                  break;
               case 22:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               case 23:
                  if (curChar == 42)
                     { jjCheckNAddTwoStates(24, 25); }
                  break;
               case 24:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(24, 25); }
                  break;
               case 25:
                  if (curChar == 42)
                     { jjAddStates(20, 21); }
                  break;
               case 26:
                  if ((0xffff7fffffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(24, 25); }
                  break;
               case 27:
                  if (curChar == 47 && kind > 8)
                     kind = 8;
                  break;
               case 28:
                  if (curChar != 47)
                     break;
                  if (kind > 9)
                     kind = 9;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 29:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 9)
                     kind = 9;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 30:
                  if ((0x2400L & l) != 0L && kind > 9)
                     kind = 9;
                  break;
               case 31:
                  if (curChar == 10 && kind > 9)
                     kind = 9;
                  break;
               case 32:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 31;
                  break;
               case 33:
                  if (curChar == 42)
                     { jjCheckNAddTwoStates(34, 35); }
                  break;
               case 34:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(34, 35); }
                  break;
               case 35:
                  if (curChar == 42)
                     { jjAddStates(22, 23); }
                  break;
               case 36:
                  if ((0xffff7fffffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(34, 35); }
                  break;
               case 37:
                  if (curChar == 47 && kind > 10)
                     kind = 10;
                  break;
               case 38:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 14)
                     kind = 14;
                  { jjCheckNAddStates(6, 8); }
                  break;
               case 39:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 14)
                     kind = 14;
                  { jjCheckNAdd(39); }
                  break;
               case 40:
                  if ((0x3ff000000000000L & l) != 0L)
                     { jjCheckNAddTwoStates(40, 41); }
                  break;
               case 41:
                  if (curChar == 46)
                     { jjCheckNAdd(42); }
                  break;
               case 42:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  { jjCheckNAdd(42); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
                  if ((0x7fffffe00000000L & l) != 0L)
                  {
                     if (kind > 54)
                        kind = 54;
                     { jjCheckNAdd(9); }
                  }
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 6;
                  else if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 6:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 54)
                        kind = 54;
                     { jjCheckNAdd(9); }
                  }
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 2:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 54)
                        kind = 54;
                     { jjCheckNAdd(9); }
                  }
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 0:
                  if (curChar == 101 && kind > 16)
                     kind = 16;
                  break;
               case 1:
                  if (curChar == 117)
                     { jjCheckNAdd(0); }
                  break;
               case 4:
                  if (curChar == 115)
                     { jjCheckNAdd(0); }
                  break;
               case 5:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 7:
                  if (curChar == 102)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 8:
                  if ((0x7fffffe00000000L & l) == 0L)
                     break;
                  if (kind > 54)
                     kind = 54;
                  { jjCheckNAdd(9); }
                  break;
               case 9:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 54)
                     kind = 54;
                  { jjCheckNAdd(9); }
                  break;
               case 11:
                  if ((0xffffffffefffffffL & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 12:
                  if (curChar == 92)
                     { jjAddStates(24, 25); }
                  break;
               case 13:
                  if ((0x14404410000000L & l) != 0L)
                     { jjCheckNAddStates(13, 15); }
                  break;
               case 19:
                  if (kind > 7)
                     kind = 7;
                  { jjAddStates(3, 5); }
                  break;
               case 24:
               case 26:
                  { jjCheckNAddTwoStates(24, 25); }
                  break;
               case 29:
                  if (kind > 9)
                     kind = 9;
                  { jjAddStates(0, 2); }
                  break;
               case 34:
               case 36:
                  { jjCheckNAddTwoStates(34, 35); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 11:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(13, 15); }
                  break;
               case 19:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  { jjAddStates(3, 5); }
                  break;
               case 24:
               case 26:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjCheckNAddTwoStates(24, 25); }
                  break;
               case 29:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 9)
                     kind = 9;
                  { jjAddStates(0, 2); }
                  break;
               case 34:
               case 36:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjCheckNAddTwoStates(34, 35); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 43 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, "\151\156\164", "\162\145\141\154", 
"\163\164\162\151\156\147", "\142\157\157\154", "\160\162\157\147\162\141\155", 
"\146\165\156\143\164\151\157\156", "\160\162\157\143\145\144\165\162\145", "\166\141\162", 
"\142\145\147\151\156", "\145\156\144", "\167\150\151\154\145", "\142\162\145\141\153", "\144\157", 
"\151\146", "\164\150\145\156", "\145\154\163\145", "\122\145\163\165\154\164", 
"\160\162\151\156\164", "\41", "\174\174", "\46\46", "\53", "\55", "\52", "\57", "\74", "\76", 
"\74\75", "\76\75", "\75\75", "\41\75", "\72\75", "\50", "\51", "\54", "\72", "\73", 
null, null, };
protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}
static final int[] jjnextStates = {
   29, 30, 32, 19, 20, 22, 39, 40, 41, 18, 23, 28, 33, 11, 12, 14, 
   11, 12, 16, 14, 26, 27, 36, 37, 13, 15, 
};

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(Exception e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public MyGrammarTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public MyGrammarTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  
  public void ReInit(SimpleCharStream stream)
  {


    jjmatchedPos =
    jjnewStateCnt =
    0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 43; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState)
  
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }


/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0xffffffffffc601L, 
};
static final long[] jjtoSkip = {
   0x1feL, 
};
static final long[] jjtoSpecial = {
   0x0L, 
};
static final long[] jjtoMore = {
   0x0L, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[43];
    private final int[] jjstateSet = new int[2 * 43];
    private final StringBuilder jjimage = new StringBuilder();
    private StringBuilder image = jjimage;
    private int jjimageLen;
    private int lengthOfMatch;
    protected int curChar;
}
