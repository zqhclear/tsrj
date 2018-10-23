package remoteexecutiontest;

/**
 * @Author: qh-zhong
 * @Date: 2018/4/20
 * 修改Class文件，暂时只提供修改常量池的功能
 */
public class ClassModifier {
    /**
     * class文件中起始常量池的偏移
     */
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    /**
     * CONSTANT_UTF8_INFO 常量的tag标志
     */
    private static final int CONSTANT_UTF8_INFO = 1;

    /**
     * 常量池中11中常量所占的长度，CONSTANT_UTF8_INFO型常量除外，因为他不是定长的
     */
    private static final int[] CONSTANT_TIME_LENGTH = {-1,-1,-1, 5,5,9,9,3,3,5,5,5,5};

    private static final int u1 = 1;
    private static final int u2 = 2;

    private byte[] classBytes;

    public ClassModifier(byte[] classBytes){
        this.classBytes = classBytes;
    }

    /**
     * 修改常量池中CONSTANT_UTF8_INFO常量的内容
     * @param oldStr 修改前的字符串
     * @param newStr 修改后的字符串
     * @return 修改结果
     */
    public byte[] modifyUTF8Constant(String oldStr, String newStr){
        int cpc = getConstantPoolCount();
        int offset = CONSTANT_POOL_COUNT_INDEX + u2;
        for(int i = 0; i < cpc;i++){
            int tag = ByteUtils.bytes2Int(classBytes, offset, u1);
            if(tag == CONSTANT_UTF8_INFO){
                int len = ByteUtils.bytes2Int(classBytes, offset + u1, u2);
                offset += (u1+u2);
                String str = ByteUtils.bytes2String(classBytes, offset, len);
                if(str.equalsIgnoreCase(oldStr)){
                    byte[] strBytes = ByteUtils.string2Bytes(newStr);
                    byte[] strLen = ByteUtils.int2Bytes(newStr.length(), u2);
                    classBytes = ByteUtils.bytesReplace(classBytes, offset - u2, u2, strLen);
                    classBytes = ByteUtils.bytesReplace(classBytes, offset, len, strBytes);
                    return classBytes;
                }else {
                    offset += len;
                }
            }else {
                offset += CONSTANT_TIME_LENGTH[tag];
            }
        }
        return classBytes;
    }

    /**
     * 获取常量池中常量的数量
     * @return 常量池中常量的数量
     */
    public int getConstantPoolCount(){
        return ByteUtils.bytes2Int(classBytes, CONSTANT_POOL_COUNT_INDEX, u2);
    }
}
