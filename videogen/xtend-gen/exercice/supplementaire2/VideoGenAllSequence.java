package exercice.supplementaire2;

import com.google.common.base.Objects;
import exercice.supplementaire2.Calcule;
import exercice.supplementaire2.Node;
import exercice.supplementaire2.SequenceVideo;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class VideoGenAllSequence {
  public VideoGeneratorModel loadVideoGenerator(final URI uri) {
    VideoGeneratorModel _xblockexpression = null;
    {
      VideoGenStandaloneSetupGenerated _videoGenStandaloneSetupGenerated = new VideoGenStandaloneSetupGenerated();
      _videoGenStandaloneSetupGenerated.createInjectorAndDoEMFRegistration();
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      Resource res = _resourceSetImpl.getResource(uri, true);
      EList<EObject> _contents = res.getContents();
      EObject _get = _contents.get(0);
      _xblockexpression = ((VideoGeneratorModel) _get);
    }
    return _xblockexpression;
  }
  
  @Test
  public void generateAllSequences() {
    try {
      URI _createURI = URI.createURI("foo2bis2.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      final ArrayList<SequenceVideo> res = this.generateSeqs(videoGen);
      int _length = ((Object[])Conversions.unwrapArray(res, Object.class)).length;
      String _plus = ("nombre de variantes : " + Integer.valueOf(_length));
      InputOutput.<String>println(_plus);
      int _minSequence = Calcule.minSequence(res);
      String _plus_1 = ("taille min de variantes : " + Integer.valueOf(_minSequence));
      InputOutput.<String>println(_plus_1);
      int _maxSequence = Calcule.maxSequence(res);
      String _plus_2 = ("taille max de variantes : " + Integer.valueOf(_maxSequence));
      InputOutput.<String>println(_plus_2);
      double _moySequence = Calcule.moySequence(res);
      String _plus_3 = ("taille moyenne de variantes : " + Double.valueOf(_moySequence));
      InputOutput.<String>println(_plus_3);
      final PrintWriter writer = new PrintWriter("sequences.csv", "UTF-8");
      final Consumer<SequenceVideo> _function = (SequenceVideo sq) -> {
        Integer _id = sq.getId();
        writer.print(_id);
        writer.print(",");
        List<String> _variantes = sq.getVariantes();
        final Consumer<String> _function_1 = (String ss) -> {
          writer.print(ss);
          writer.print(",");
        };
        _variantes.forEach(_function_1);
        writer.println();
      };
      res.forEach(_function);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void extractTailleMin(final ArrayList<SequenceVideo> videos) {
    final int res = 100;
    final Consumer<SequenceVideo> _function = (SequenceVideo sv) -> {
      List<String> _variantes = sv.getVariantes();
      int _size = _variantes.size();
      Math.min(_size, res);
    };
    videos.forEach(_function);
  }
  
  public ArrayList<SequenceVideo> generateSeqs(final VideoGeneratorModel videoGen) {
    ArrayList<SequenceVideo> _xblockexpression = null;
    {
      final Node parent = new Node();
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          String _location = desc.getLocation();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_location);
          boolean _not = (!_isNullOrEmpty);
          if (_not) {
            ArrayList<Node> nodeFis = new ArrayList<Node>();
            Node _node = new Node();
            nodeFis.add(_node);
            Node _get = nodeFis.get(0);
            String _location_1 = desc.getLocation();
            _get.setName(_location_1);
            this.addFisToParent(parent, nodeFis);
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            String _location_2 = desc_1.getLocation();
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_2);
            boolean _not_1 = (!_isNullOrEmpty_1);
            if (_not_1) {
              ArrayList<Node> nodeFis_1 = new ArrayList<Node>();
              Node _node_1 = new Node();
              nodeFis_1.add(_node_1);
              Node _get_1 = nodeFis_1.get(0);
              String _location_3 = desc_1.getLocation();
              _get_1.setName(_location_3);
              Node _node_2 = new Node();
              nodeFis_1.add(_node_2);
              Node _get_2 = nodeFis_1.get(1);
              _get_2.setName("_neutre_");
              this.addFisToParent(parent, nodeFis_1);
            }
          } else {
            if ((videoseq instanceof AlternativeVideoSeq)) {
              final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
              final ArrayList<Node> nodeFis_2 = new ArrayList<Node>();
              EList<VideoDescription> _videodescs = altvid.getVideodescs();
              for (final VideoDescription vdesc : _videodescs) {
                String _location_4 = vdesc.getLocation();
                boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_location_4);
                boolean _not_2 = (!_isNullOrEmpty_2);
                if (_not_2) {
                  Node subnode = new Node();
                  nodeFis_2.add(subnode);
                  String _location_5 = vdesc.getLocation();
                  subnode.setName(_location_5);
                }
              }
              this.addFisToParent(parent, nodeFis_2);
            }
          }
        }
      };
      _videoseqs.forEach(_function);
      final ArrayList<SequenceVideo> seqs = new ArrayList<SequenceVideo>();
      this.updateParent(parent);
      this.checkParents(parent);
      this.extractListSeqs(parent, seqs);
      _xblockexpression = seqs;
    }
    return _xblockexpression;
  }
  
  private static int i = 0;
  
  public Boolean extractListSeqs(final Node node, final ArrayList<SequenceVideo> seqs) {
    boolean _xifexpression = false;
    List<Node> _listSub = node.getListSub();
    int _length = ((Object[])Conversions.unwrapArray(_listSub, Object.class)).length;
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      List<Node> _listSub_1 = node.getListSub();
      for (final Node subnode : _listSub_1) {
        this.extractListSeqs(subnode, seqs);
      }
    } else {
      boolean _xblockexpression = false;
      {
        SequenceVideo seq = new SequenceVideo();
        int _plusPlus = VideoGenAllSequence.i++;
        seq.setId(Integer.valueOf(_plusPlus));
        ArrayList<String> seqVar = new ArrayList<String>();
        this.extractVariantes(node, seqVar);
        seq.setVariantes(seqVar);
        _xblockexpression = seqs.add(seq);
      }
      _xifexpression = _xblockexpression;
    }
    return Boolean.valueOf(_xifexpression);
  }
  
  public void checkParents(final Node node) {
    List<Node> _listSub = node.getListSub();
    final Consumer<Node> _function = (Node subnode) -> {
      this.checkParents(subnode);
    };
    _listSub.forEach(_function);
  }
  
  public Object extractVariantes(final Node node, final List<String> seqVar) {
    Object _xblockexpression = null;
    {
      if (((!Objects.equal(node.getName(), null)) && (!Objects.equal(node.getName(), "_neutre_")))) {
        String _name = node.getName();
        seqVar.add(_name);
      }
      Object _xifexpression = null;
      Node _parentNode = node.getParentNode();
      boolean _notEquals = (!Objects.equal(_parentNode, null));
      if (_notEquals) {
        Node _parentNode_1 = node.getParentNode();
        _xifexpression = this.extractVariantes(_parentNode_1, seqVar);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public void addFisToParent(final Node parent, final ArrayList<Node> nodes) {
    boolean _contains = nodes.contains(parent);
    if (_contains) {
      return;
    }
    List<Node> _listSub = parent.getListSub();
    int _length = ((Object[])Conversions.unwrapArray(_listSub, Object.class)).length;
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      final List<Node> arr = parent.getListSub();
      final Consumer<Node> _function = (Node nid) -> {
        boolean _contains_1 = nodes.contains(nid);
        boolean _not = (!_contains_1);
        if (_not) {
          this.addFisToParent(nid, nodes);
        }
      };
      arr.forEach(_function);
    } else {
      List<Node> _listSub_1 = parent.getListSub();
      ArrayList<Node> _copyArray = this.copyArray(nodes);
      _listSub_1.addAll(_copyArray);
    }
  }
  
  public ArrayList<Node> copyArray(final ArrayList<Node> nodes) {
    final ArrayList<Node> res = new ArrayList<Node>();
    final Consumer<Node> _function = (Node nod) -> {
      final Node nn = new Node();
      List<Node> _listSub = nod.getListSub();
      nn.setListSub(_listSub);
      String _name = nod.getName();
      nn.setName(_name);
      res.add(nn);
    };
    nodes.forEach(_function);
    return res;
  }
  
  public void updateParent(final Node nod) {
    List<Node> _listSub = nod.getListSub();
    for (final Node sub : _listSub) {
      {
        sub.setParentNode(nod);
        this.updateParent(sub);
      }
    }
  }
}
