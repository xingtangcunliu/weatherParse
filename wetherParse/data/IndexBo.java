package com.cvicse.base.common.data;

/**
 * 指数类
 * Created by liu_zlu on 2016/8/13 21:17
 */
public class IndexBo {

    /*
    <zhishus>
<zhishu>
<name>晨练指数</name>
<value>不宜</value>
<detail>有较强降水，请避免户外晨练，建议在室内做适当锻炼，保持身体健康。</detail>
</zhishu>
<zhishu>
<name>舒适度</name>
<value>较不舒适</value>
<detail>白天虽然有雨，但仍无法削弱较高气温带来的暑意，同时降雨造成湿度加大会您感到有些闷热，不很舒适。</detail>
</zhishu>
<zhishu>
<name>穿衣指数</name>
<value>热</value>
<detail>天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。</detail>
</zhishu>
<zhishu>
<name>感冒指数</name>
<value>少发</value>
<detail>各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。</detail>
</zhishu>
<zhishu>
<name>晾晒指数</name>
<value>不宜</value>
<detail>有较强降水，不适宜晾晒。若需要晾晒，请在室内准备出充足的空间。</detail>
</zhishu>
<zhishu>
<name>旅游指数</name>
<value>较不宜</value>
<detail>天气稍热，风力不大，但有有较强降水，会给您的出行产生很多麻烦，建议您最好还是多选择在室内活动吧！</detail>
</zhishu>
<zhishu>
<name>紫外线强度</name>
<value>弱</value>
<detail>紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。</detail>
</zhishu>
<zhishu>
<name>洗车指数</name>
<value>不宜</value>
<detail>不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。</detail>
</zhishu>
<zhishu>
<name>运动指数</name>
<value>较不宜</value>
<detail>有较强降水，建议您选择在室内进行健身休闲运动。</detail>
</zhishu>
<zhishu>
<name>约会指数</name>
<value>不适宜</value>
<detail>天气较热，同时较强降水天气会给室外约会增添许多麻烦，最好在室内促膝谈心。</detail>
</zhishu>
<zhishu>
<name>雨伞指数</name>
<value>带伞</value>
<detail>有较强降水，您在外出的时候一定要带雨伞，以免被雨水淋湿。</detail>
</zhishu>
</zhishus>
     */
    /**
     * 指数名
     */
    private String name = "";

    private String value = "";

    private String detail = "";

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isEnd = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
