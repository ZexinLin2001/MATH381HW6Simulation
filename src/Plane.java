import java.util.List;

public class Plane {
    private int index;
    private int position;
    private int color;
    private boolean end;

    public Plane(int index, int position, int color) {
        this.index = index;
        this.position = position;
        this.color = color;
        this.end = false;
    }

    public int getIndex() {
        return index;
    }

    public int getPosition() {
        return position;
    }

    public int getColor() {
        return color;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    //Zexin Lin: last Update @ 11/10 11PM : Fly from one side of dot line to the other side
    /**
     *
     * @param  num: the number of dice rolled
     * @return int value: possible location can move to, otherwise return -1
     */
    public int[] canMoveTo(int num, List<Plane> planes) throws RuntimeException {
        if (!end) {
            int nextPosition, score;
            // if the plane currently in the base at position 0, 1, 2, 3
            if (position < 4) {
                if (num == 6) {
                    nextPosition = position + 4;
                    score = 6;
                } else { //不需要出动飞机 return：-1
                    nextPosition = -1;
                    score = 0;
                }
            }
            //if the plane currently in launch point at position 4, 5, 6, 7
            else if (position < 8) {
                //blue is a special case -> position 4 是蓝色的起飞点
                if (position == 4) {
                    if (num == 1) { //if dice a one we move to position 59
                        nextPosition = 59;
                    } else {
                        nextPosition = 6 + num; //第一个蓝色的格子为8， 前一个为59
                    }
                } //This is general case for YGR launch position Y = 4; G = 5; R = 6
                //color index Y = 1; G = 2; R = 3
                else {
                    nextPosition = 6 + 13 * color + num;
                }
                if (nextPosition % 4 == color) {
                    nextPosition += 4;
                }

                // calculate the score
                if (num == 2 || num == 6) {
                    score = num + 4;
                } else {
                    score = num;
                }
            }
            // normal board situation in board position 8, 9, 10, ... , 59
            else if (position < 60) {
                nextPosition = position + num; //next position is current position plus the diced number
                score = num;
                // check the color, may need to go to landing arrow 到达最终长箭头出口
                //蓝色较为特殊单独讨论
                if (color == 0 && nextPosition > 56 && position <= 56) {
                    int excess = nextPosition - 56;
                    nextPosition = 56 + excess * 4;
                    score = num - excess + 1;
                }//黄绿蓝general条件
                else if ((color == 1 && nextPosition > 17 && position <= 17) ||
                        (color == 2 && nextPosition > 30 && position <= 30) ||
                        (color == 3 && nextPosition > 43 && position <= 43)) {
                    int excess = nextPosition - ((color - 1) * 13 + 17); //nextPosition - excess position
                    nextPosition = 56 + color + excess * 4;
                    score = num - excess + 1;
                } else {
                    //jump from same color spot to next same color spot
                    boolean jumped = false;
                    if ((nextPosition % 4 == color)) {
                        if (nextPosition > 59) {
                            nextPosition = nextPosition % 59 + 7;
                        }
                        if ((color == 0 && nextPosition == 24) ||
                                (color == 1 && nextPosition == 37) ||
                                (color == 2 && nextPosition == 50) ||
                                (color == 3 && nextPosition == 11)) {
                            nextPosition += 12;
                            score += 12;
                        }
                        if (nextPosition > 59) {
                            nextPosition = nextPosition % 59 + 7;
                        }
                        nextPosition += 4;
                        score += 4;
                        jumped = true;
                        if (nextPosition > 59) {
                            nextPosition = nextPosition % 59 + 7;
                        }
                        if ((color == 0 && nextPosition == 24) ||
                                (color == 1 && nextPosition == 37) ||
                                (color == 2 && nextPosition == 50) ||
                                (color == 3 && nextPosition == 11)) {
                            nextPosition += 12;
                            score += 12;
                        }
                    }
                    if (nextPosition > 59) {
                        nextPosition = nextPosition % 59 + 7;
                    }
                    if ((!jumped) && (nextPosition % 4 == color)) {
                        nextPosition += 4;
                        score += 4;
                        jumped = true;
                    }

                    //ensure not over the index
                    if (nextPosition > 59) {
                        nextPosition = nextPosition % 59 + 7;
                    }
                }
            } else if (position < 84) { //此时都已经进入landing的长箭头 index 在60和84之间
                nextPosition = position + (num * 4);
                //结束条件->送入机库
                if ((color == 0 && nextPosition == 80) ||
                        (color == 1 && nextPosition == 81) ||
                        (color == 2 && nextPosition == 82) ||
                        (color == 3 && nextPosition == 83)) {
//                    nextPosition += 4; //标志结束
                    end = true; // 这架飞机结束了
                    score = 6;
                    // 超出了需要退回
                } else if ((color == 0 && nextPosition > 80) ||
                        (color == 1 && nextPosition > 81) ||
                        (color == 2 && nextPosition > 82) ||
                        (color == 3 && nextPosition > 83)) {
                    nextPosition -= 2 * (nextPosition - (color + 80)); //减去超出部分（超出部分只有可能是4的倍数）
                    if (nextPosition >= 68 && nextPosition <= 71) {
                        score = 0;
                    } else {
                        score = 1;
                    }
                } else {
                    if (nextPosition >= 68 && nextPosition <= 71) {
                        score = 0;
                    } else {
                        score = 1;
                    }
                }
                //正常触及到下一个位置-游戏继续
            } else {
                throw new RuntimeException();
            }

            int[] temp = {nextPosition, score};
            return temp;
        } else {
            int[] temp = {-1, -1};
            return temp;
        }
    }
}
