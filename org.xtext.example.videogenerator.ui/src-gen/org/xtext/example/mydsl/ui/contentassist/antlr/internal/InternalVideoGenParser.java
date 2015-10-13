package org.xtext.example.mydsl.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.xtext.example.mydsl.services.VideoGenGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVideoGenParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_LEFT_BRACKET", "RULE_RIGHT_BRACKET", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'VideoGen'", "'@author'", "'@version'", "'@creation'", "'mandatory'", "'optional'", "'alternatives'", "'videoseq'", "'duration'", "'probability'", "'description'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int RULE_RIGHT_BRACKET=5;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=7;
    public static final int RULE_WS=11;
    public static final int RULE_LEFT_BRACKET=4;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_INT=8;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalVideoGenParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVideoGenParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVideoGenParser.tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g"; }


     
     	private VideoGenGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(VideoGenGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleVideoGeneratorModel"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:60:1: entryRuleVideoGeneratorModel : ruleVideoGeneratorModel EOF ;
    public final void entryRuleVideoGeneratorModel() throws RecognitionException {
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:61:1: ( ruleVideoGeneratorModel EOF )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:62:1: ruleVideoGeneratorModel EOF
            {
             before(grammarAccess.getVideoGeneratorModelRule()); 
            pushFollow(FOLLOW_ruleVideoGeneratorModel_in_entryRuleVideoGeneratorModel61);
            ruleVideoGeneratorModel();

            state._fsp--;

             after(grammarAccess.getVideoGeneratorModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVideoGeneratorModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVideoGeneratorModel"


    // $ANTLR start "ruleVideoGeneratorModel"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:69:1: ruleVideoGeneratorModel : ( ( rule__VideoGeneratorModel__Group__0 ) ) ;
    public final void ruleVideoGeneratorModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:73:2: ( ( ( rule__VideoGeneratorModel__Group__0 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:74:1: ( ( rule__VideoGeneratorModel__Group__0 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:74:1: ( ( rule__VideoGeneratorModel__Group__0 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:75:1: ( rule__VideoGeneratorModel__Group__0 )
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getGroup()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:76:1: ( rule__VideoGeneratorModel__Group__0 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:76:2: rule__VideoGeneratorModel__Group__0
            {
            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__0_in_ruleVideoGeneratorModel94);
            rule__VideoGeneratorModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVideoGeneratorModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVideoGeneratorModel"


    // $ANTLR start "entryRuleVideoGenInformation"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:88:1: entryRuleVideoGenInformation : ruleVideoGenInformation EOF ;
    public final void entryRuleVideoGenInformation() throws RecognitionException {
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:89:1: ( ruleVideoGenInformation EOF )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:90:1: ruleVideoGenInformation EOF
            {
             before(grammarAccess.getVideoGenInformationRule()); 
            pushFollow(FOLLOW_ruleVideoGenInformation_in_entryRuleVideoGenInformation121);
            ruleVideoGenInformation();

            state._fsp--;

             after(grammarAccess.getVideoGenInformationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVideoGenInformation128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVideoGenInformation"


    // $ANTLR start "ruleVideoGenInformation"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:97:1: ruleVideoGenInformation : ( ( rule__VideoGenInformation__Group__0 ) ) ;
    public final void ruleVideoGenInformation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:101:2: ( ( ( rule__VideoGenInformation__Group__0 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:102:1: ( ( rule__VideoGenInformation__Group__0 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:102:1: ( ( rule__VideoGenInformation__Group__0 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:103:1: ( rule__VideoGenInformation__Group__0 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:104:1: ( rule__VideoGenInformation__Group__0 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:104:2: rule__VideoGenInformation__Group__0
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__Group__0_in_ruleVideoGenInformation154);
            rule__VideoGenInformation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVideoGenInformationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVideoGenInformation"


    // $ANTLR start "entryRuleVideoSeq"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:116:1: entryRuleVideoSeq : ruleVideoSeq EOF ;
    public final void entryRuleVideoSeq() throws RecognitionException {
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:117:1: ( ruleVideoSeq EOF )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:118:1: ruleVideoSeq EOF
            {
             before(grammarAccess.getVideoSeqRule()); 
            pushFollow(FOLLOW_ruleVideoSeq_in_entryRuleVideoSeq181);
            ruleVideoSeq();

            state._fsp--;

             after(grammarAccess.getVideoSeqRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVideoSeq188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVideoSeq"


    // $ANTLR start "ruleVideoSeq"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:125:1: ruleVideoSeq : ( ( rule__VideoSeq__Alternatives ) ) ;
    public final void ruleVideoSeq() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:129:2: ( ( ( rule__VideoSeq__Alternatives ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:130:1: ( ( rule__VideoSeq__Alternatives ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:130:1: ( ( rule__VideoSeq__Alternatives ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:131:1: ( rule__VideoSeq__Alternatives )
            {
             before(grammarAccess.getVideoSeqAccess().getAlternatives()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:132:1: ( rule__VideoSeq__Alternatives )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:132:2: rule__VideoSeq__Alternatives
            {
            pushFollow(FOLLOW_rule__VideoSeq__Alternatives_in_ruleVideoSeq214);
            rule__VideoSeq__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVideoSeqAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVideoSeq"


    // $ANTLR start "entryRuleMandatoryVideoSeq"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:144:1: entryRuleMandatoryVideoSeq : ruleMandatoryVideoSeq EOF ;
    public final void entryRuleMandatoryVideoSeq() throws RecognitionException {
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:145:1: ( ruleMandatoryVideoSeq EOF )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:146:1: ruleMandatoryVideoSeq EOF
            {
             before(grammarAccess.getMandatoryVideoSeqRule()); 
            pushFollow(FOLLOW_ruleMandatoryVideoSeq_in_entryRuleMandatoryVideoSeq241);
            ruleMandatoryVideoSeq();

            state._fsp--;

             after(grammarAccess.getMandatoryVideoSeqRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMandatoryVideoSeq248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMandatoryVideoSeq"


    // $ANTLR start "ruleMandatoryVideoSeq"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:153:1: ruleMandatoryVideoSeq : ( ( rule__MandatoryVideoSeq__Group__0 ) ) ;
    public final void ruleMandatoryVideoSeq() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:157:2: ( ( ( rule__MandatoryVideoSeq__Group__0 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:158:1: ( ( rule__MandatoryVideoSeq__Group__0 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:158:1: ( ( rule__MandatoryVideoSeq__Group__0 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:159:1: ( rule__MandatoryVideoSeq__Group__0 )
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getGroup()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:160:1: ( rule__MandatoryVideoSeq__Group__0 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:160:2: rule__MandatoryVideoSeq__Group__0
            {
            pushFollow(FOLLOW_rule__MandatoryVideoSeq__Group__0_in_ruleMandatoryVideoSeq274);
            rule__MandatoryVideoSeq__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMandatoryVideoSeqAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMandatoryVideoSeq"


    // $ANTLR start "entryRuleOptionalVideoSeq"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:172:1: entryRuleOptionalVideoSeq : ruleOptionalVideoSeq EOF ;
    public final void entryRuleOptionalVideoSeq() throws RecognitionException {
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:173:1: ( ruleOptionalVideoSeq EOF )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:174:1: ruleOptionalVideoSeq EOF
            {
             before(grammarAccess.getOptionalVideoSeqRule()); 
            pushFollow(FOLLOW_ruleOptionalVideoSeq_in_entryRuleOptionalVideoSeq301);
            ruleOptionalVideoSeq();

            state._fsp--;

             after(grammarAccess.getOptionalVideoSeqRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptionalVideoSeq308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOptionalVideoSeq"


    // $ANTLR start "ruleOptionalVideoSeq"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:181:1: ruleOptionalVideoSeq : ( ( rule__OptionalVideoSeq__Group__0 ) ) ;
    public final void ruleOptionalVideoSeq() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:185:2: ( ( ( rule__OptionalVideoSeq__Group__0 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:186:1: ( ( rule__OptionalVideoSeq__Group__0 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:186:1: ( ( rule__OptionalVideoSeq__Group__0 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:187:1: ( rule__OptionalVideoSeq__Group__0 )
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getGroup()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:188:1: ( rule__OptionalVideoSeq__Group__0 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:188:2: rule__OptionalVideoSeq__Group__0
            {
            pushFollow(FOLLOW_rule__OptionalVideoSeq__Group__0_in_ruleOptionalVideoSeq334);
            rule__OptionalVideoSeq__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOptionalVideoSeqAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOptionalVideoSeq"


    // $ANTLR start "entryRuleAlternativeVideoSeq"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:200:1: entryRuleAlternativeVideoSeq : ruleAlternativeVideoSeq EOF ;
    public final void entryRuleAlternativeVideoSeq() throws RecognitionException {
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:201:1: ( ruleAlternativeVideoSeq EOF )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:202:1: ruleAlternativeVideoSeq EOF
            {
             before(grammarAccess.getAlternativeVideoSeqRule()); 
            pushFollow(FOLLOW_ruleAlternativeVideoSeq_in_entryRuleAlternativeVideoSeq361);
            ruleAlternativeVideoSeq();

            state._fsp--;

             after(grammarAccess.getAlternativeVideoSeqRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternativeVideoSeq368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAlternativeVideoSeq"


    // $ANTLR start "ruleAlternativeVideoSeq"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:209:1: ruleAlternativeVideoSeq : ( ( rule__AlternativeVideoSeq__Group__0 ) ) ;
    public final void ruleAlternativeVideoSeq() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:213:2: ( ( ( rule__AlternativeVideoSeq__Group__0 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:214:1: ( ( rule__AlternativeVideoSeq__Group__0 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:214:1: ( ( rule__AlternativeVideoSeq__Group__0 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:215:1: ( rule__AlternativeVideoSeq__Group__0 )
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getGroup()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:216:1: ( rule__AlternativeVideoSeq__Group__0 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:216:2: rule__AlternativeVideoSeq__Group__0
            {
            pushFollow(FOLLOW_rule__AlternativeVideoSeq__Group__0_in_ruleAlternativeVideoSeq394);
            rule__AlternativeVideoSeq__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeVideoSeqAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlternativeVideoSeq"


    // $ANTLR start "entryRuleVideoDescription"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:228:1: entryRuleVideoDescription : ruleVideoDescription EOF ;
    public final void entryRuleVideoDescription() throws RecognitionException {
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:229:1: ( ruleVideoDescription EOF )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:230:1: ruleVideoDescription EOF
            {
             before(grammarAccess.getVideoDescriptionRule()); 
            pushFollow(FOLLOW_ruleVideoDescription_in_entryRuleVideoDescription421);
            ruleVideoDescription();

            state._fsp--;

             after(grammarAccess.getVideoDescriptionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVideoDescription428); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVideoDescription"


    // $ANTLR start "ruleVideoDescription"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:237:1: ruleVideoDescription : ( ( rule__VideoDescription__Group__0 ) ) ;
    public final void ruleVideoDescription() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:241:2: ( ( ( rule__VideoDescription__Group__0 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:242:1: ( ( rule__VideoDescription__Group__0 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:242:1: ( ( rule__VideoDescription__Group__0 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:243:1: ( rule__VideoDescription__Group__0 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:244:1: ( rule__VideoDescription__Group__0 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:244:2: rule__VideoDescription__Group__0
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group__0_in_ruleVideoDescription454);
            rule__VideoDescription__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVideoDescription"


    // $ANTLR start "rule__VideoSeq__Alternatives"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:256:1: rule__VideoSeq__Alternatives : ( ( ruleMandatoryVideoSeq ) | ( ruleOptionalVideoSeq ) | ( ruleAlternativeVideoSeq ) );
    public final void rule__VideoSeq__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:260:1: ( ( ruleMandatoryVideoSeq ) | ( ruleOptionalVideoSeq ) | ( ruleAlternativeVideoSeq ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt1=1;
                }
                break;
            case 18:
                {
                alt1=2;
                }
                break;
            case 19:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:261:1: ( ruleMandatoryVideoSeq )
                    {
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:261:1: ( ruleMandatoryVideoSeq )
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:262:1: ruleMandatoryVideoSeq
                    {
                     before(grammarAccess.getVideoSeqAccess().getMandatoryVideoSeqParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleMandatoryVideoSeq_in_rule__VideoSeq__Alternatives490);
                    ruleMandatoryVideoSeq();

                    state._fsp--;

                     after(grammarAccess.getVideoSeqAccess().getMandatoryVideoSeqParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:267:6: ( ruleOptionalVideoSeq )
                    {
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:267:6: ( ruleOptionalVideoSeq )
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:268:1: ruleOptionalVideoSeq
                    {
                     before(grammarAccess.getVideoSeqAccess().getOptionalVideoSeqParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleOptionalVideoSeq_in_rule__VideoSeq__Alternatives507);
                    ruleOptionalVideoSeq();

                    state._fsp--;

                     after(grammarAccess.getVideoSeqAccess().getOptionalVideoSeqParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:273:6: ( ruleAlternativeVideoSeq )
                    {
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:273:6: ( ruleAlternativeVideoSeq )
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:274:1: ruleAlternativeVideoSeq
                    {
                     before(grammarAccess.getVideoSeqAccess().getAlternativeVideoSeqParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleAlternativeVideoSeq_in_rule__VideoSeq__Alternatives524);
                    ruleAlternativeVideoSeq();

                    state._fsp--;

                     after(grammarAccess.getVideoSeqAccess().getAlternativeVideoSeqParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoSeq__Alternatives"


    // $ANTLR start "rule__VideoGeneratorModel__Group__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:286:1: rule__VideoGeneratorModel__Group__0 : rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1 ;
    public final void rule__VideoGeneratorModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:290:1: ( rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:291:2: rule__VideoGeneratorModel__Group__0__Impl rule__VideoGeneratorModel__Group__1
            {
            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__0__Impl_in_rule__VideoGeneratorModel__Group__0554);
            rule__VideoGeneratorModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__1_in_rule__VideoGeneratorModel__Group__0557);
            rule__VideoGeneratorModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__0"


    // $ANTLR start "rule__VideoGeneratorModel__Group__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:298:1: rule__VideoGeneratorModel__Group__0__Impl : ( () ) ;
    public final void rule__VideoGeneratorModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:302:1: ( ( () ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:303:1: ( () )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:303:1: ( () )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:304:1: ()
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoGeneratorModelAction_0()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:305:1: ()
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:307:1: 
            {
            }

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoGeneratorModelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__0__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__Group__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:317:1: rule__VideoGeneratorModel__Group__1 : rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2 ;
    public final void rule__VideoGeneratorModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:321:1: ( rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:322:2: rule__VideoGeneratorModel__Group__1__Impl rule__VideoGeneratorModel__Group__2
            {
            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__1__Impl_in_rule__VideoGeneratorModel__Group__1615);
            rule__VideoGeneratorModel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__2_in_rule__VideoGeneratorModel__Group__1618);
            rule__VideoGeneratorModel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__1"


    // $ANTLR start "rule__VideoGeneratorModel__Group__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:329:1: rule__VideoGeneratorModel__Group__1__Impl : ( ( rule__VideoGeneratorModel__InformationAssignment_1 ) ) ;
    public final void rule__VideoGeneratorModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:333:1: ( ( ( rule__VideoGeneratorModel__InformationAssignment_1 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:334:1: ( ( rule__VideoGeneratorModel__InformationAssignment_1 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:334:1: ( ( rule__VideoGeneratorModel__InformationAssignment_1 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:335:1: ( rule__VideoGeneratorModel__InformationAssignment_1 )
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getInformationAssignment_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:336:1: ( rule__VideoGeneratorModel__InformationAssignment_1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:336:2: rule__VideoGeneratorModel__InformationAssignment_1
            {
            pushFollow(FOLLOW_rule__VideoGeneratorModel__InformationAssignment_1_in_rule__VideoGeneratorModel__Group__1__Impl645);
            rule__VideoGeneratorModel__InformationAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoGeneratorModelAccess().getInformationAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__1__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__Group__2"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:346:1: rule__VideoGeneratorModel__Group__2 : rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3 ;
    public final void rule__VideoGeneratorModel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:350:1: ( rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:351:2: rule__VideoGeneratorModel__Group__2__Impl rule__VideoGeneratorModel__Group__3
            {
            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__2__Impl_in_rule__VideoGeneratorModel__Group__2675);
            rule__VideoGeneratorModel__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__3_in_rule__VideoGeneratorModel__Group__2678);
            rule__VideoGeneratorModel__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__2"


    // $ANTLR start "rule__VideoGeneratorModel__Group__2__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:358:1: rule__VideoGeneratorModel__Group__2__Impl : ( 'VideoGen' ) ;
    public final void rule__VideoGeneratorModel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:362:1: ( ( 'VideoGen' ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:363:1: ( 'VideoGen' )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:363:1: ( 'VideoGen' )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:364:1: 'VideoGen'
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoGenKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__VideoGeneratorModel__Group__2__Impl706); 
             after(grammarAccess.getVideoGeneratorModelAccess().getVideoGenKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__2__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__Group__3"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:377:1: rule__VideoGeneratorModel__Group__3 : rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4 ;
    public final void rule__VideoGeneratorModel__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:381:1: ( rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:382:2: rule__VideoGeneratorModel__Group__3__Impl rule__VideoGeneratorModel__Group__4
            {
            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__3__Impl_in_rule__VideoGeneratorModel__Group__3737);
            rule__VideoGeneratorModel__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__4_in_rule__VideoGeneratorModel__Group__3740);
            rule__VideoGeneratorModel__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__3"


    // $ANTLR start "rule__VideoGeneratorModel__Group__3__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:389:1: rule__VideoGeneratorModel__Group__3__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__VideoGeneratorModel__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:393:1: ( ( RULE_LEFT_BRACKET ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:394:1: ( RULE_LEFT_BRACKET )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:394:1: ( RULE_LEFT_BRACKET )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:395:1: RULE_LEFT_BRACKET
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getLEFT_BRACKETTerminalRuleCall_3()); 
            match(input,RULE_LEFT_BRACKET,FOLLOW_RULE_LEFT_BRACKET_in_rule__VideoGeneratorModel__Group__3__Impl767); 
             after(grammarAccess.getVideoGeneratorModelAccess().getLEFT_BRACKETTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__3__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__Group__4"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:406:1: rule__VideoGeneratorModel__Group__4 : rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5 ;
    public final void rule__VideoGeneratorModel__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:410:1: ( rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:411:2: rule__VideoGeneratorModel__Group__4__Impl rule__VideoGeneratorModel__Group__5
            {
            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__4__Impl_in_rule__VideoGeneratorModel__Group__4796);
            rule__VideoGeneratorModel__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__5_in_rule__VideoGeneratorModel__Group__4799);
            rule__VideoGeneratorModel__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__4"


    // $ANTLR start "rule__VideoGeneratorModel__Group__4__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:418:1: rule__VideoGeneratorModel__Group__4__Impl : ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) ) ;
    public final void rule__VideoGeneratorModel__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:422:1: ( ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:423:1: ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:423:1: ( ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:424:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) ) ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:424:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:425:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:426:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:426:2: rule__VideoGeneratorModel__VideoseqsAssignment_4
            {
            pushFollow(FOLLOW_rule__VideoGeneratorModel__VideoseqsAssignment_4_in_rule__VideoGeneratorModel__Group__4__Impl828);
            rule__VideoGeneratorModel__VideoseqsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 

            }

            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:429:1: ( ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )* )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:430:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )*
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:431:1: ( rule__VideoGeneratorModel__VideoseqsAssignment_4 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=17 && LA2_0<=19)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:431:2: rule__VideoGeneratorModel__VideoseqsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__VideoGeneratorModel__VideoseqsAssignment_4_in_rule__VideoGeneratorModel__Group__4__Impl840);
            	    rule__VideoGeneratorModel__VideoseqsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsAssignment_4()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__4__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__Group__5"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:442:1: rule__VideoGeneratorModel__Group__5 : rule__VideoGeneratorModel__Group__5__Impl ;
    public final void rule__VideoGeneratorModel__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:446:1: ( rule__VideoGeneratorModel__Group__5__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:447:2: rule__VideoGeneratorModel__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__VideoGeneratorModel__Group__5__Impl_in_rule__VideoGeneratorModel__Group__5873);
            rule__VideoGeneratorModel__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__5"


    // $ANTLR start "rule__VideoGeneratorModel__Group__5__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:453:1: rule__VideoGeneratorModel__Group__5__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__VideoGeneratorModel__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:457:1: ( ( RULE_RIGHT_BRACKET ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:458:1: ( RULE_RIGHT_BRACKET )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:458:1: ( RULE_RIGHT_BRACKET )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:459:1: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getRIGHT_BRACKETTerminalRuleCall_5()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_RULE_RIGHT_BRACKET_in_rule__VideoGeneratorModel__Group__5__Impl900); 
             after(grammarAccess.getVideoGeneratorModelAccess().getRIGHT_BRACKETTerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__Group__5__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:482:1: rule__VideoGenInformation__Group__0 : rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1 ;
    public final void rule__VideoGenInformation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:486:1: ( rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:487:2: rule__VideoGenInformation__Group__0__Impl rule__VideoGenInformation__Group__1
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__Group__0__Impl_in_rule__VideoGenInformation__Group__0941);
            rule__VideoGenInformation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoGenInformation__Group__1_in_rule__VideoGenInformation__Group__0944);
            rule__VideoGenInformation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group__0"


    // $ANTLR start "rule__VideoGenInformation__Group__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:494:1: rule__VideoGenInformation__Group__0__Impl : ( () ) ;
    public final void rule__VideoGenInformation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:498:1: ( ( () ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:499:1: ( () )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:499:1: ( () )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:500:1: ()
            {
             before(grammarAccess.getVideoGenInformationAccess().getVideoGenInformationAction_0()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:501:1: ()
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:503:1: 
            {
            }

             after(grammarAccess.getVideoGenInformationAccess().getVideoGenInformationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group__0__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:513:1: rule__VideoGenInformation__Group__1 : rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2 ;
    public final void rule__VideoGenInformation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:517:1: ( rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:518:2: rule__VideoGenInformation__Group__1__Impl rule__VideoGenInformation__Group__2
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__Group__1__Impl_in_rule__VideoGenInformation__Group__11002);
            rule__VideoGenInformation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoGenInformation__Group__2_in_rule__VideoGenInformation__Group__11005);
            rule__VideoGenInformation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group__1"


    // $ANTLR start "rule__VideoGenInformation__Group__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:525:1: rule__VideoGenInformation__Group__1__Impl : ( ( rule__VideoGenInformation__Group_1__0 )? ) ;
    public final void rule__VideoGenInformation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:529:1: ( ( ( rule__VideoGenInformation__Group_1__0 )? ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:530:1: ( ( rule__VideoGenInformation__Group_1__0 )? )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:530:1: ( ( rule__VideoGenInformation__Group_1__0 )? )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:531:1: ( rule__VideoGenInformation__Group_1__0 )?
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:532:1: ( rule__VideoGenInformation__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:532:2: rule__VideoGenInformation__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__VideoGenInformation__Group_1__0_in_rule__VideoGenInformation__Group__1__Impl1032);
                    rule__VideoGenInformation__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoGenInformationAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group__1__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group__2"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:542:1: rule__VideoGenInformation__Group__2 : rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3 ;
    public final void rule__VideoGenInformation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:546:1: ( rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:547:2: rule__VideoGenInformation__Group__2__Impl rule__VideoGenInformation__Group__3
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__Group__2__Impl_in_rule__VideoGenInformation__Group__21063);
            rule__VideoGenInformation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoGenInformation__Group__3_in_rule__VideoGenInformation__Group__21066);
            rule__VideoGenInformation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group__2"


    // $ANTLR start "rule__VideoGenInformation__Group__2__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:554:1: rule__VideoGenInformation__Group__2__Impl : ( ( rule__VideoGenInformation__Group_2__0 )? ) ;
    public final void rule__VideoGenInformation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:558:1: ( ( ( rule__VideoGenInformation__Group_2__0 )? ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:559:1: ( ( rule__VideoGenInformation__Group_2__0 )? )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:559:1: ( ( rule__VideoGenInformation__Group_2__0 )? )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:560:1: ( rule__VideoGenInformation__Group_2__0 )?
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_2()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:561:1: ( rule__VideoGenInformation__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:561:2: rule__VideoGenInformation__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__VideoGenInformation__Group_2__0_in_rule__VideoGenInformation__Group__2__Impl1093);
                    rule__VideoGenInformation__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoGenInformationAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group__2__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group__3"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:571:1: rule__VideoGenInformation__Group__3 : rule__VideoGenInformation__Group__3__Impl ;
    public final void rule__VideoGenInformation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:575:1: ( rule__VideoGenInformation__Group__3__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:576:2: rule__VideoGenInformation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__Group__3__Impl_in_rule__VideoGenInformation__Group__31124);
            rule__VideoGenInformation__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group__3"


    // $ANTLR start "rule__VideoGenInformation__Group__3__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:582:1: rule__VideoGenInformation__Group__3__Impl : ( ( rule__VideoGenInformation__Group_3__0 )? ) ;
    public final void rule__VideoGenInformation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:586:1: ( ( ( rule__VideoGenInformation__Group_3__0 )? ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:587:1: ( ( rule__VideoGenInformation__Group_3__0 )? )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:587:1: ( ( rule__VideoGenInformation__Group_3__0 )? )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:588:1: ( rule__VideoGenInformation__Group_3__0 )?
            {
             before(grammarAccess.getVideoGenInformationAccess().getGroup_3()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:589:1: ( rule__VideoGenInformation__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:589:2: rule__VideoGenInformation__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__VideoGenInformation__Group_3__0_in_rule__VideoGenInformation__Group__3__Impl1151);
                    rule__VideoGenInformation__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoGenInformationAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group__3__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_1__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:607:1: rule__VideoGenInformation__Group_1__0 : rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1 ;
    public final void rule__VideoGenInformation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:611:1: ( rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:612:2: rule__VideoGenInformation__Group_1__0__Impl rule__VideoGenInformation__Group_1__1
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__Group_1__0__Impl_in_rule__VideoGenInformation__Group_1__01190);
            rule__VideoGenInformation__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoGenInformation__Group_1__1_in_rule__VideoGenInformation__Group_1__01193);
            rule__VideoGenInformation__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_1__0"


    // $ANTLR start "rule__VideoGenInformation__Group_1__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:619:1: rule__VideoGenInformation__Group_1__0__Impl : ( '@author' ) ;
    public final void rule__VideoGenInformation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:623:1: ( ( '@author' ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:624:1: ( '@author' )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:624:1: ( '@author' )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:625:1: '@author'
            {
             before(grammarAccess.getVideoGenInformationAccess().getAuthorKeyword_1_0()); 
            match(input,14,FOLLOW_14_in_rule__VideoGenInformation__Group_1__0__Impl1221); 
             after(grammarAccess.getVideoGenInformationAccess().getAuthorKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_1__0__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_1__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:638:1: rule__VideoGenInformation__Group_1__1 : rule__VideoGenInformation__Group_1__1__Impl ;
    public final void rule__VideoGenInformation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:642:1: ( rule__VideoGenInformation__Group_1__1__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:643:2: rule__VideoGenInformation__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__Group_1__1__Impl_in_rule__VideoGenInformation__Group_1__11252);
            rule__VideoGenInformation__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_1__1"


    // $ANTLR start "rule__VideoGenInformation__Group_1__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:649:1: rule__VideoGenInformation__Group_1__1__Impl : ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) ) ;
    public final void rule__VideoGenInformation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:653:1: ( ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:654:1: ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:654:1: ( ( rule__VideoGenInformation__AuthorNameAssignment_1_1 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:655:1: ( rule__VideoGenInformation__AuthorNameAssignment_1_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getAuthorNameAssignment_1_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:656:1: ( rule__VideoGenInformation__AuthorNameAssignment_1_1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:656:2: rule__VideoGenInformation__AuthorNameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__AuthorNameAssignment_1_1_in_rule__VideoGenInformation__Group_1__1__Impl1279);
            rule__VideoGenInformation__AuthorNameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoGenInformationAccess().getAuthorNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_1__1__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_2__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:670:1: rule__VideoGenInformation__Group_2__0 : rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1 ;
    public final void rule__VideoGenInformation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:674:1: ( rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:675:2: rule__VideoGenInformation__Group_2__0__Impl rule__VideoGenInformation__Group_2__1
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__Group_2__0__Impl_in_rule__VideoGenInformation__Group_2__01313);
            rule__VideoGenInformation__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoGenInformation__Group_2__1_in_rule__VideoGenInformation__Group_2__01316);
            rule__VideoGenInformation__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_2__0"


    // $ANTLR start "rule__VideoGenInformation__Group_2__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:682:1: rule__VideoGenInformation__Group_2__0__Impl : ( '@version' ) ;
    public final void rule__VideoGenInformation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:686:1: ( ( '@version' ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:687:1: ( '@version' )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:687:1: ( '@version' )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:688:1: '@version'
            {
             before(grammarAccess.getVideoGenInformationAccess().getVersionKeyword_2_0()); 
            match(input,15,FOLLOW_15_in_rule__VideoGenInformation__Group_2__0__Impl1344); 
             after(grammarAccess.getVideoGenInformationAccess().getVersionKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_2__0__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_2__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:701:1: rule__VideoGenInformation__Group_2__1 : rule__VideoGenInformation__Group_2__1__Impl ;
    public final void rule__VideoGenInformation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:705:1: ( rule__VideoGenInformation__Group_2__1__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:706:2: rule__VideoGenInformation__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__Group_2__1__Impl_in_rule__VideoGenInformation__Group_2__11375);
            rule__VideoGenInformation__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_2__1"


    // $ANTLR start "rule__VideoGenInformation__Group_2__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:712:1: rule__VideoGenInformation__Group_2__1__Impl : ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) ) ;
    public final void rule__VideoGenInformation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:716:1: ( ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:717:1: ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:717:1: ( ( rule__VideoGenInformation__VersionAssignment_2_1 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:718:1: ( rule__VideoGenInformation__VersionAssignment_2_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getVersionAssignment_2_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:719:1: ( rule__VideoGenInformation__VersionAssignment_2_1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:719:2: rule__VideoGenInformation__VersionAssignment_2_1
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__VersionAssignment_2_1_in_rule__VideoGenInformation__Group_2__1__Impl1402);
            rule__VideoGenInformation__VersionAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoGenInformationAccess().getVersionAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_2__1__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_3__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:733:1: rule__VideoGenInformation__Group_3__0 : rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1 ;
    public final void rule__VideoGenInformation__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:737:1: ( rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:738:2: rule__VideoGenInformation__Group_3__0__Impl rule__VideoGenInformation__Group_3__1
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__Group_3__0__Impl_in_rule__VideoGenInformation__Group_3__01436);
            rule__VideoGenInformation__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoGenInformation__Group_3__1_in_rule__VideoGenInformation__Group_3__01439);
            rule__VideoGenInformation__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_3__0"


    // $ANTLR start "rule__VideoGenInformation__Group_3__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:745:1: rule__VideoGenInformation__Group_3__0__Impl : ( '@creation' ) ;
    public final void rule__VideoGenInformation__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:749:1: ( ( '@creation' ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:750:1: ( '@creation' )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:750:1: ( '@creation' )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:751:1: '@creation'
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationKeyword_3_0()); 
            match(input,16,FOLLOW_16_in_rule__VideoGenInformation__Group_3__0__Impl1467); 
             after(grammarAccess.getVideoGenInformationAccess().getCreationKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_3__0__Impl"


    // $ANTLR start "rule__VideoGenInformation__Group_3__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:764:1: rule__VideoGenInformation__Group_3__1 : rule__VideoGenInformation__Group_3__1__Impl ;
    public final void rule__VideoGenInformation__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:768:1: ( rule__VideoGenInformation__Group_3__1__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:769:2: rule__VideoGenInformation__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__Group_3__1__Impl_in_rule__VideoGenInformation__Group_3__11498);
            rule__VideoGenInformation__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_3__1"


    // $ANTLR start "rule__VideoGenInformation__Group_3__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:775:1: rule__VideoGenInformation__Group_3__1__Impl : ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) ) ;
    public final void rule__VideoGenInformation__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:779:1: ( ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:780:1: ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:780:1: ( ( rule__VideoGenInformation__CreationDateAssignment_3_1 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:781:1: ( rule__VideoGenInformation__CreationDateAssignment_3_1 )
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationDateAssignment_3_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:782:1: ( rule__VideoGenInformation__CreationDateAssignment_3_1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:782:2: rule__VideoGenInformation__CreationDateAssignment_3_1
            {
            pushFollow(FOLLOW_rule__VideoGenInformation__CreationDateAssignment_3_1_in_rule__VideoGenInformation__Group_3__1__Impl1525);
            rule__VideoGenInformation__CreationDateAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoGenInformationAccess().getCreationDateAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__Group_3__1__Impl"


    // $ANTLR start "rule__MandatoryVideoSeq__Group__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:796:1: rule__MandatoryVideoSeq__Group__0 : rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1 ;
    public final void rule__MandatoryVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:800:1: ( rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:801:2: rule__MandatoryVideoSeq__Group__0__Impl rule__MandatoryVideoSeq__Group__1
            {
            pushFollow(FOLLOW_rule__MandatoryVideoSeq__Group__0__Impl_in_rule__MandatoryVideoSeq__Group__01559);
            rule__MandatoryVideoSeq__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MandatoryVideoSeq__Group__1_in_rule__MandatoryVideoSeq__Group__01562);
            rule__MandatoryVideoSeq__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryVideoSeq__Group__0"


    // $ANTLR start "rule__MandatoryVideoSeq__Group__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:808:1: rule__MandatoryVideoSeq__Group__0__Impl : ( 'mandatory' ) ;
    public final void rule__MandatoryVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:812:1: ( ( 'mandatory' ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:813:1: ( 'mandatory' )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:813:1: ( 'mandatory' )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:814:1: 'mandatory'
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getMandatoryKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__MandatoryVideoSeq__Group__0__Impl1590); 
             after(grammarAccess.getMandatoryVideoSeqAccess().getMandatoryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryVideoSeq__Group__0__Impl"


    // $ANTLR start "rule__MandatoryVideoSeq__Group__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:827:1: rule__MandatoryVideoSeq__Group__1 : rule__MandatoryVideoSeq__Group__1__Impl ;
    public final void rule__MandatoryVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:831:1: ( rule__MandatoryVideoSeq__Group__1__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:832:2: rule__MandatoryVideoSeq__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MandatoryVideoSeq__Group__1__Impl_in_rule__MandatoryVideoSeq__Group__11621);
            rule__MandatoryVideoSeq__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryVideoSeq__Group__1"


    // $ANTLR start "rule__MandatoryVideoSeq__Group__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:838:1: rule__MandatoryVideoSeq__Group__1__Impl : ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) ) ;
    public final void rule__MandatoryVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:842:1: ( ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:843:1: ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:843:1: ( ( rule__MandatoryVideoSeq__DescriptionAssignment_1 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:844:1: ( rule__MandatoryVideoSeq__DescriptionAssignment_1 )
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionAssignment_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:845:1: ( rule__MandatoryVideoSeq__DescriptionAssignment_1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:845:2: rule__MandatoryVideoSeq__DescriptionAssignment_1
            {
            pushFollow(FOLLOW_rule__MandatoryVideoSeq__DescriptionAssignment_1_in_rule__MandatoryVideoSeq__Group__1__Impl1648);
            rule__MandatoryVideoSeq__DescriptionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryVideoSeq__Group__1__Impl"


    // $ANTLR start "rule__OptionalVideoSeq__Group__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:859:1: rule__OptionalVideoSeq__Group__0 : rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1 ;
    public final void rule__OptionalVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:863:1: ( rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:864:2: rule__OptionalVideoSeq__Group__0__Impl rule__OptionalVideoSeq__Group__1
            {
            pushFollow(FOLLOW_rule__OptionalVideoSeq__Group__0__Impl_in_rule__OptionalVideoSeq__Group__01682);
            rule__OptionalVideoSeq__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__OptionalVideoSeq__Group__1_in_rule__OptionalVideoSeq__Group__01685);
            rule__OptionalVideoSeq__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalVideoSeq__Group__0"


    // $ANTLR start "rule__OptionalVideoSeq__Group__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:871:1: rule__OptionalVideoSeq__Group__0__Impl : ( 'optional' ) ;
    public final void rule__OptionalVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:875:1: ( ( 'optional' ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:876:1: ( 'optional' )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:876:1: ( 'optional' )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:877:1: 'optional'
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getOptionalKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__OptionalVideoSeq__Group__0__Impl1713); 
             after(grammarAccess.getOptionalVideoSeqAccess().getOptionalKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalVideoSeq__Group__0__Impl"


    // $ANTLR start "rule__OptionalVideoSeq__Group__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:890:1: rule__OptionalVideoSeq__Group__1 : rule__OptionalVideoSeq__Group__1__Impl ;
    public final void rule__OptionalVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:894:1: ( rule__OptionalVideoSeq__Group__1__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:895:2: rule__OptionalVideoSeq__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__OptionalVideoSeq__Group__1__Impl_in_rule__OptionalVideoSeq__Group__11744);
            rule__OptionalVideoSeq__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalVideoSeq__Group__1"


    // $ANTLR start "rule__OptionalVideoSeq__Group__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:901:1: rule__OptionalVideoSeq__Group__1__Impl : ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) ) ;
    public final void rule__OptionalVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:905:1: ( ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:906:1: ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:906:1: ( ( rule__OptionalVideoSeq__DescriptionAssignment_1 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:907:1: ( rule__OptionalVideoSeq__DescriptionAssignment_1 )
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getDescriptionAssignment_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:908:1: ( rule__OptionalVideoSeq__DescriptionAssignment_1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:908:2: rule__OptionalVideoSeq__DescriptionAssignment_1
            {
            pushFollow(FOLLOW_rule__OptionalVideoSeq__DescriptionAssignment_1_in_rule__OptionalVideoSeq__Group__1__Impl1771);
            rule__OptionalVideoSeq__DescriptionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOptionalVideoSeqAccess().getDescriptionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalVideoSeq__Group__1__Impl"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:922:1: rule__AlternativeVideoSeq__Group__0 : rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1 ;
    public final void rule__AlternativeVideoSeq__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:926:1: ( rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:927:2: rule__AlternativeVideoSeq__Group__0__Impl rule__AlternativeVideoSeq__Group__1
            {
            pushFollow(FOLLOW_rule__AlternativeVideoSeq__Group__0__Impl_in_rule__AlternativeVideoSeq__Group__01805);
            rule__AlternativeVideoSeq__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AlternativeVideoSeq__Group__1_in_rule__AlternativeVideoSeq__Group__01808);
            rule__AlternativeVideoSeq__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__Group__0"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:934:1: rule__AlternativeVideoSeq__Group__0__Impl : ( 'alternatives' ) ;
    public final void rule__AlternativeVideoSeq__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:938:1: ( ( 'alternatives' ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:939:1: ( 'alternatives' )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:939:1: ( 'alternatives' )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:940:1: 'alternatives'
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getAlternativesKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__AlternativeVideoSeq__Group__0__Impl1836); 
             after(grammarAccess.getAlternativeVideoSeqAccess().getAlternativesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__Group__0__Impl"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:953:1: rule__AlternativeVideoSeq__Group__1 : rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2 ;
    public final void rule__AlternativeVideoSeq__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:957:1: ( rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:958:2: rule__AlternativeVideoSeq__Group__1__Impl rule__AlternativeVideoSeq__Group__2
            {
            pushFollow(FOLLOW_rule__AlternativeVideoSeq__Group__1__Impl_in_rule__AlternativeVideoSeq__Group__11867);
            rule__AlternativeVideoSeq__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AlternativeVideoSeq__Group__2_in_rule__AlternativeVideoSeq__Group__11870);
            rule__AlternativeVideoSeq__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__Group__1"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:965:1: rule__AlternativeVideoSeq__Group__1__Impl : ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? ) ;
    public final void rule__AlternativeVideoSeq__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:969:1: ( ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:970:1: ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:970:1: ( ( rule__AlternativeVideoSeq__VideoidAssignment_1 )? )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:971:1: ( rule__AlternativeVideoSeq__VideoidAssignment_1 )?
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideoidAssignment_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:972:1: ( rule__AlternativeVideoSeq__VideoidAssignment_1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:972:2: rule__AlternativeVideoSeq__VideoidAssignment_1
                    {
                    pushFollow(FOLLOW_rule__AlternativeVideoSeq__VideoidAssignment_1_in_rule__AlternativeVideoSeq__Group__1__Impl1897);
                    rule__AlternativeVideoSeq__VideoidAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAlternativeVideoSeqAccess().getVideoidAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__Group__1__Impl"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__2"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:982:1: rule__AlternativeVideoSeq__Group__2 : rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3 ;
    public final void rule__AlternativeVideoSeq__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:986:1: ( rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:987:2: rule__AlternativeVideoSeq__Group__2__Impl rule__AlternativeVideoSeq__Group__3
            {
            pushFollow(FOLLOW_rule__AlternativeVideoSeq__Group__2__Impl_in_rule__AlternativeVideoSeq__Group__21928);
            rule__AlternativeVideoSeq__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AlternativeVideoSeq__Group__3_in_rule__AlternativeVideoSeq__Group__21931);
            rule__AlternativeVideoSeq__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__Group__2"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__2__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:994:1: rule__AlternativeVideoSeq__Group__2__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__AlternativeVideoSeq__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:998:1: ( ( RULE_LEFT_BRACKET ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:999:1: ( RULE_LEFT_BRACKET )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:999:1: ( RULE_LEFT_BRACKET )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1000:1: RULE_LEFT_BRACKET
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getLEFT_BRACKETTerminalRuleCall_2()); 
            match(input,RULE_LEFT_BRACKET,FOLLOW_RULE_LEFT_BRACKET_in_rule__AlternativeVideoSeq__Group__2__Impl1958); 
             after(grammarAccess.getAlternativeVideoSeqAccess().getLEFT_BRACKETTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__Group__2__Impl"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__3"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1011:1: rule__AlternativeVideoSeq__Group__3 : rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4 ;
    public final void rule__AlternativeVideoSeq__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1015:1: ( rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1016:2: rule__AlternativeVideoSeq__Group__3__Impl rule__AlternativeVideoSeq__Group__4
            {
            pushFollow(FOLLOW_rule__AlternativeVideoSeq__Group__3__Impl_in_rule__AlternativeVideoSeq__Group__31987);
            rule__AlternativeVideoSeq__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AlternativeVideoSeq__Group__4_in_rule__AlternativeVideoSeq__Group__31990);
            rule__AlternativeVideoSeq__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__Group__3"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__3__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1023:1: rule__AlternativeVideoSeq__Group__3__Impl : ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) ) ;
    public final void rule__AlternativeVideoSeq__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1027:1: ( ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1028:1: ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1028:1: ( ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1029:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) ) ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1029:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1030:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1031:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1031:2: rule__AlternativeVideoSeq__VideodescsAssignment_3
            {
            pushFollow(FOLLOW_rule__AlternativeVideoSeq__VideodescsAssignment_3_in_rule__AlternativeVideoSeq__Group__3__Impl2019);
            rule__AlternativeVideoSeq__VideodescsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 

            }

            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1034:1: ( ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )* )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1035:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )*
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1036:1: ( rule__AlternativeVideoSeq__VideodescsAssignment_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==20) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1036:2: rule__AlternativeVideoSeq__VideodescsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__AlternativeVideoSeq__VideodescsAssignment_3_in_rule__AlternativeVideoSeq__Group__3__Impl2031);
            	    rule__AlternativeVideoSeq__VideodescsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsAssignment_3()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__Group__3__Impl"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__4"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1047:1: rule__AlternativeVideoSeq__Group__4 : rule__AlternativeVideoSeq__Group__4__Impl ;
    public final void rule__AlternativeVideoSeq__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1051:1: ( rule__AlternativeVideoSeq__Group__4__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1052:2: rule__AlternativeVideoSeq__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__AlternativeVideoSeq__Group__4__Impl_in_rule__AlternativeVideoSeq__Group__42064);
            rule__AlternativeVideoSeq__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__Group__4"


    // $ANTLR start "rule__AlternativeVideoSeq__Group__4__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1058:1: rule__AlternativeVideoSeq__Group__4__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__AlternativeVideoSeq__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1062:1: ( ( RULE_RIGHT_BRACKET ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1063:1: ( RULE_RIGHT_BRACKET )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1063:1: ( RULE_RIGHT_BRACKET )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1064:1: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getRIGHT_BRACKETTerminalRuleCall_4()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_RULE_RIGHT_BRACKET_in_rule__AlternativeVideoSeq__Group__4__Impl2091); 
             after(grammarAccess.getAlternativeVideoSeqAccess().getRIGHT_BRACKETTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__Group__4__Impl"


    // $ANTLR start "rule__VideoDescription__Group__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1085:1: rule__VideoDescription__Group__0 : rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1 ;
    public final void rule__VideoDescription__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1089:1: ( rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1090:2: rule__VideoDescription__Group__0__Impl rule__VideoDescription__Group__1
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group__0__Impl_in_rule__VideoDescription__Group__02130);
            rule__VideoDescription__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoDescription__Group__1_in_rule__VideoDescription__Group__02133);
            rule__VideoDescription__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group__0"


    // $ANTLR start "rule__VideoDescription__Group__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1097:1: rule__VideoDescription__Group__0__Impl : ( 'videoseq' ) ;
    public final void rule__VideoDescription__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1101:1: ( ( 'videoseq' ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1102:1: ( 'videoseq' )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1102:1: ( 'videoseq' )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1103:1: 'videoseq'
            {
             before(grammarAccess.getVideoDescriptionAccess().getVideoseqKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__VideoDescription__Group__0__Impl2161); 
             after(grammarAccess.getVideoDescriptionAccess().getVideoseqKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1116:1: rule__VideoDescription__Group__1 : rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2 ;
    public final void rule__VideoDescription__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1120:1: ( rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1121:2: rule__VideoDescription__Group__1__Impl rule__VideoDescription__Group__2
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group__1__Impl_in_rule__VideoDescription__Group__12192);
            rule__VideoDescription__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoDescription__Group__2_in_rule__VideoDescription__Group__12195);
            rule__VideoDescription__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group__1"


    // $ANTLR start "rule__VideoDescription__Group__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1128:1: rule__VideoDescription__Group__1__Impl : ( ( rule__VideoDescription__VideoidAssignment_1 )? ) ;
    public final void rule__VideoDescription__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1132:1: ( ( ( rule__VideoDescription__VideoidAssignment_1 )? ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1133:1: ( ( rule__VideoDescription__VideoidAssignment_1 )? )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1133:1: ( ( rule__VideoDescription__VideoidAssignment_1 )? )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1134:1: ( rule__VideoDescription__VideoidAssignment_1 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getVideoidAssignment_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1135:1: ( rule__VideoDescription__VideoidAssignment_1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1135:2: rule__VideoDescription__VideoidAssignment_1
                    {
                    pushFollow(FOLLOW_rule__VideoDescription__VideoidAssignment_1_in_rule__VideoDescription__Group__1__Impl2222);
                    rule__VideoDescription__VideoidAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getVideoidAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group__1__Impl"


    // $ANTLR start "rule__VideoDescription__Group__2"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1145:1: rule__VideoDescription__Group__2 : rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3 ;
    public final void rule__VideoDescription__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1149:1: ( rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1150:2: rule__VideoDescription__Group__2__Impl rule__VideoDescription__Group__3
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group__2__Impl_in_rule__VideoDescription__Group__22253);
            rule__VideoDescription__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoDescription__Group__3_in_rule__VideoDescription__Group__22256);
            rule__VideoDescription__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group__2"


    // $ANTLR start "rule__VideoDescription__Group__2__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1157:1: rule__VideoDescription__Group__2__Impl : ( ( rule__VideoDescription__LocationAssignment_2 ) ) ;
    public final void rule__VideoDescription__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1161:1: ( ( ( rule__VideoDescription__LocationAssignment_2 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1162:1: ( ( rule__VideoDescription__LocationAssignment_2 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1162:1: ( ( rule__VideoDescription__LocationAssignment_2 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1163:1: ( rule__VideoDescription__LocationAssignment_2 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getLocationAssignment_2()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1164:1: ( rule__VideoDescription__LocationAssignment_2 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1164:2: rule__VideoDescription__LocationAssignment_2
            {
            pushFollow(FOLLOW_rule__VideoDescription__LocationAssignment_2_in_rule__VideoDescription__Group__2__Impl2283);
            rule__VideoDescription__LocationAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getLocationAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group__2__Impl"


    // $ANTLR start "rule__VideoDescription__Group__3"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1174:1: rule__VideoDescription__Group__3 : rule__VideoDescription__Group__3__Impl ;
    public final void rule__VideoDescription__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1178:1: ( rule__VideoDescription__Group__3__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1179:2: rule__VideoDescription__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group__3__Impl_in_rule__VideoDescription__Group__32313);
            rule__VideoDescription__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group__3"


    // $ANTLR start "rule__VideoDescription__Group__3__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1185:1: rule__VideoDescription__Group__3__Impl : ( ( rule__VideoDescription__Group_3__0 )? ) ;
    public final void rule__VideoDescription__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1189:1: ( ( ( rule__VideoDescription__Group_3__0 )? ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1190:1: ( ( rule__VideoDescription__Group_3__0 )? )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1190:1: ( ( rule__VideoDescription__Group_3__0 )? )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1191:1: ( rule__VideoDescription__Group_3__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1192:1: ( rule__VideoDescription__Group_3__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_LEFT_BRACKET) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1192:2: rule__VideoDescription__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__VideoDescription__Group_3__0_in_rule__VideoDescription__Group__3__Impl2340);
                    rule__VideoDescription__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group__3__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1210:1: rule__VideoDescription__Group_3__0 : rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1 ;
    public final void rule__VideoDescription__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1214:1: ( rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1215:2: rule__VideoDescription__Group_3__0__Impl rule__VideoDescription__Group_3__1
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group_3__0__Impl_in_rule__VideoDescription__Group_3__02379);
            rule__VideoDescription__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoDescription__Group_3__1_in_rule__VideoDescription__Group_3__02382);
            rule__VideoDescription__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3__0"


    // $ANTLR start "rule__VideoDescription__Group_3__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1222:1: rule__VideoDescription__Group_3__0__Impl : ( RULE_LEFT_BRACKET ) ;
    public final void rule__VideoDescription__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1226:1: ( ( RULE_LEFT_BRACKET ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1227:1: ( RULE_LEFT_BRACKET )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1227:1: ( RULE_LEFT_BRACKET )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1228:1: RULE_LEFT_BRACKET
            {
             before(grammarAccess.getVideoDescriptionAccess().getLEFT_BRACKETTerminalRuleCall_3_0()); 
            match(input,RULE_LEFT_BRACKET,FOLLOW_RULE_LEFT_BRACKET_in_rule__VideoDescription__Group_3__0__Impl2409); 
             after(grammarAccess.getVideoDescriptionAccess().getLEFT_BRACKETTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1239:1: rule__VideoDescription__Group_3__1 : rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2 ;
    public final void rule__VideoDescription__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1243:1: ( rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1244:2: rule__VideoDescription__Group_3__1__Impl rule__VideoDescription__Group_3__2
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group_3__1__Impl_in_rule__VideoDescription__Group_3__12438);
            rule__VideoDescription__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoDescription__Group_3__2_in_rule__VideoDescription__Group_3__12441);
            rule__VideoDescription__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3__1"


    // $ANTLR start "rule__VideoDescription__Group_3__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1251:1: rule__VideoDescription__Group_3__1__Impl : ( ( rule__VideoDescription__Group_3_1__0 )? ) ;
    public final void rule__VideoDescription__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1255:1: ( ( ( rule__VideoDescription__Group_3_1__0 )? ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1256:1: ( ( rule__VideoDescription__Group_3_1__0 )? )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1256:1: ( ( rule__VideoDescription__Group_3_1__0 )? )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1257:1: ( rule__VideoDescription__Group_3_1__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1258:1: ( rule__VideoDescription__Group_3_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1258:2: rule__VideoDescription__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__VideoDescription__Group_3_1__0_in_rule__VideoDescription__Group_3__1__Impl2468);
                    rule__VideoDescription__Group_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3__1__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__2"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1268:1: rule__VideoDescription__Group_3__2 : rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3 ;
    public final void rule__VideoDescription__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1272:1: ( rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1273:2: rule__VideoDescription__Group_3__2__Impl rule__VideoDescription__Group_3__3
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group_3__2__Impl_in_rule__VideoDescription__Group_3__22499);
            rule__VideoDescription__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoDescription__Group_3__3_in_rule__VideoDescription__Group_3__22502);
            rule__VideoDescription__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3__2"


    // $ANTLR start "rule__VideoDescription__Group_3__2__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1280:1: rule__VideoDescription__Group_3__2__Impl : ( ( rule__VideoDescription__Group_3_2__0 )? ) ;
    public final void rule__VideoDescription__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1284:1: ( ( ( rule__VideoDescription__Group_3_2__0 )? ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1285:1: ( ( rule__VideoDescription__Group_3_2__0 )? )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1285:1: ( ( rule__VideoDescription__Group_3_2__0 )? )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1286:1: ( rule__VideoDescription__Group_3_2__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_2()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1287:1: ( rule__VideoDescription__Group_3_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==22) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1287:2: rule__VideoDescription__Group_3_2__0
                    {
                    pushFollow(FOLLOW_rule__VideoDescription__Group_3_2__0_in_rule__VideoDescription__Group_3__2__Impl2529);
                    rule__VideoDescription__Group_3_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3__2__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__3"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1297:1: rule__VideoDescription__Group_3__3 : rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4 ;
    public final void rule__VideoDescription__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1301:1: ( rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1302:2: rule__VideoDescription__Group_3__3__Impl rule__VideoDescription__Group_3__4
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group_3__3__Impl_in_rule__VideoDescription__Group_3__32560);
            rule__VideoDescription__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoDescription__Group_3__4_in_rule__VideoDescription__Group_3__32563);
            rule__VideoDescription__Group_3__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3__3"


    // $ANTLR start "rule__VideoDescription__Group_3__3__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1309:1: rule__VideoDescription__Group_3__3__Impl : ( ( rule__VideoDescription__Group_3_3__0 )? ) ;
    public final void rule__VideoDescription__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1313:1: ( ( ( rule__VideoDescription__Group_3_3__0 )? ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1314:1: ( ( rule__VideoDescription__Group_3_3__0 )? )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1314:1: ( ( rule__VideoDescription__Group_3_3__0 )? )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1315:1: ( rule__VideoDescription__Group_3_3__0 )?
            {
             before(grammarAccess.getVideoDescriptionAccess().getGroup_3_3()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1316:1: ( rule__VideoDescription__Group_3_3__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1316:2: rule__VideoDescription__Group_3_3__0
                    {
                    pushFollow(FOLLOW_rule__VideoDescription__Group_3_3__0_in_rule__VideoDescription__Group_3__3__Impl2590);
                    rule__VideoDescription__Group_3_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVideoDescriptionAccess().getGroup_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3__3__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3__4"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1326:1: rule__VideoDescription__Group_3__4 : rule__VideoDescription__Group_3__4__Impl ;
    public final void rule__VideoDescription__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1330:1: ( rule__VideoDescription__Group_3__4__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1331:2: rule__VideoDescription__Group_3__4__Impl
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group_3__4__Impl_in_rule__VideoDescription__Group_3__42621);
            rule__VideoDescription__Group_3__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3__4"


    // $ANTLR start "rule__VideoDescription__Group_3__4__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1337:1: rule__VideoDescription__Group_3__4__Impl : ( RULE_RIGHT_BRACKET ) ;
    public final void rule__VideoDescription__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1341:1: ( ( RULE_RIGHT_BRACKET ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1342:1: ( RULE_RIGHT_BRACKET )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1342:1: ( RULE_RIGHT_BRACKET )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1343:1: RULE_RIGHT_BRACKET
            {
             before(grammarAccess.getVideoDescriptionAccess().getRIGHT_BRACKETTerminalRuleCall_3_4()); 
            match(input,RULE_RIGHT_BRACKET,FOLLOW_RULE_RIGHT_BRACKET_in_rule__VideoDescription__Group_3__4__Impl2648); 
             after(grammarAccess.getVideoDescriptionAccess().getRIGHT_BRACKETTerminalRuleCall_3_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3__4__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_1__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1364:1: rule__VideoDescription__Group_3_1__0 : rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1 ;
    public final void rule__VideoDescription__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1368:1: ( rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1369:2: rule__VideoDescription__Group_3_1__0__Impl rule__VideoDescription__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group_3_1__0__Impl_in_rule__VideoDescription__Group_3_1__02687);
            rule__VideoDescription__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoDescription__Group_3_1__1_in_rule__VideoDescription__Group_3_1__02690);
            rule__VideoDescription__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_1__0"


    // $ANTLR start "rule__VideoDescription__Group_3_1__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1376:1: rule__VideoDescription__Group_3_1__0__Impl : ( 'duration' ) ;
    public final void rule__VideoDescription__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1380:1: ( ( 'duration' ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1381:1: ( 'duration' )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1381:1: ( 'duration' )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1382:1: 'duration'
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationKeyword_3_1_0()); 
            match(input,21,FOLLOW_21_in_rule__VideoDescription__Group_3_1__0__Impl2718); 
             after(grammarAccess.getVideoDescriptionAccess().getDurationKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_1__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_1__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1395:1: rule__VideoDescription__Group_3_1__1 : rule__VideoDescription__Group_3_1__1__Impl ;
    public final void rule__VideoDescription__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1399:1: ( rule__VideoDescription__Group_3_1__1__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1400:2: rule__VideoDescription__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group_3_1__1__Impl_in_rule__VideoDescription__Group_3_1__12749);
            rule__VideoDescription__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_1__1"


    // $ANTLR start "rule__VideoDescription__Group_3_1__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1406:1: rule__VideoDescription__Group_3_1__1__Impl : ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) ) ;
    public final void rule__VideoDescription__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1410:1: ( ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1411:1: ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1411:1: ( ( rule__VideoDescription__DurationAssignment_3_1_1 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1412:1: ( rule__VideoDescription__DurationAssignment_3_1_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationAssignment_3_1_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1413:1: ( rule__VideoDescription__DurationAssignment_3_1_1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1413:2: rule__VideoDescription__DurationAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__VideoDescription__DurationAssignment_3_1_1_in_rule__VideoDescription__Group_3_1__1__Impl2776);
            rule__VideoDescription__DurationAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getDurationAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_1__1__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_2__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1427:1: rule__VideoDescription__Group_3_2__0 : rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1 ;
    public final void rule__VideoDescription__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1431:1: ( rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1432:2: rule__VideoDescription__Group_3_2__0__Impl rule__VideoDescription__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group_3_2__0__Impl_in_rule__VideoDescription__Group_3_2__02810);
            rule__VideoDescription__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoDescription__Group_3_2__1_in_rule__VideoDescription__Group_3_2__02813);
            rule__VideoDescription__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_2__0"


    // $ANTLR start "rule__VideoDescription__Group_3_2__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1439:1: rule__VideoDescription__Group_3_2__0__Impl : ( 'probability' ) ;
    public final void rule__VideoDescription__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1443:1: ( ( 'probability' ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1444:1: ( 'probability' )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1444:1: ( 'probability' )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1445:1: 'probability'
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityKeyword_3_2_0()); 
            match(input,22,FOLLOW_22_in_rule__VideoDescription__Group_3_2__0__Impl2841); 
             after(grammarAccess.getVideoDescriptionAccess().getProbabilityKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_2__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_2__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1458:1: rule__VideoDescription__Group_3_2__1 : rule__VideoDescription__Group_3_2__1__Impl ;
    public final void rule__VideoDescription__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1462:1: ( rule__VideoDescription__Group_3_2__1__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1463:2: rule__VideoDescription__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group_3_2__1__Impl_in_rule__VideoDescription__Group_3_2__12872);
            rule__VideoDescription__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_2__1"


    // $ANTLR start "rule__VideoDescription__Group_3_2__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1469:1: rule__VideoDescription__Group_3_2__1__Impl : ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) ) ;
    public final void rule__VideoDescription__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1473:1: ( ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1474:1: ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1474:1: ( ( rule__VideoDescription__ProbabilityAssignment_3_2_1 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1475:1: ( rule__VideoDescription__ProbabilityAssignment_3_2_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityAssignment_3_2_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1476:1: ( rule__VideoDescription__ProbabilityAssignment_3_2_1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1476:2: rule__VideoDescription__ProbabilityAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__VideoDescription__ProbabilityAssignment_3_2_1_in_rule__VideoDescription__Group_3_2__1__Impl2899);
            rule__VideoDescription__ProbabilityAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getProbabilityAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_2__1__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_3__0"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1490:1: rule__VideoDescription__Group_3_3__0 : rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1 ;
    public final void rule__VideoDescription__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1494:1: ( rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1495:2: rule__VideoDescription__Group_3_3__0__Impl rule__VideoDescription__Group_3_3__1
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group_3_3__0__Impl_in_rule__VideoDescription__Group_3_3__02933);
            rule__VideoDescription__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VideoDescription__Group_3_3__1_in_rule__VideoDescription__Group_3_3__02936);
            rule__VideoDescription__Group_3_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_3__0"


    // $ANTLR start "rule__VideoDescription__Group_3_3__0__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1502:1: rule__VideoDescription__Group_3_3__0__Impl : ( 'description' ) ;
    public final void rule__VideoDescription__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1506:1: ( ( 'description' ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1507:1: ( 'description' )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1507:1: ( 'description' )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1508:1: 'description'
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_3_0()); 
            match(input,23,FOLLOW_23_in_rule__VideoDescription__Group_3_3__0__Impl2964); 
             after(grammarAccess.getVideoDescriptionAccess().getDescriptionKeyword_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_3__0__Impl"


    // $ANTLR start "rule__VideoDescription__Group_3_3__1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1521:1: rule__VideoDescription__Group_3_3__1 : rule__VideoDescription__Group_3_3__1__Impl ;
    public final void rule__VideoDescription__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1525:1: ( rule__VideoDescription__Group_3_3__1__Impl )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1526:2: rule__VideoDescription__Group_3_3__1__Impl
            {
            pushFollow(FOLLOW_rule__VideoDescription__Group_3_3__1__Impl_in_rule__VideoDescription__Group_3_3__12995);
            rule__VideoDescription__Group_3_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_3__1"


    // $ANTLR start "rule__VideoDescription__Group_3_3__1__Impl"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1532:1: rule__VideoDescription__Group_3_3__1__Impl : ( ( rule__VideoDescription__DescriptionAssignment_3_3_1 ) ) ;
    public final void rule__VideoDescription__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1536:1: ( ( ( rule__VideoDescription__DescriptionAssignment_3_3_1 ) ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1537:1: ( ( rule__VideoDescription__DescriptionAssignment_3_3_1 ) )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1537:1: ( ( rule__VideoDescription__DescriptionAssignment_3_3_1 ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1538:1: ( rule__VideoDescription__DescriptionAssignment_3_3_1 )
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionAssignment_3_3_1()); 
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1539:1: ( rule__VideoDescription__DescriptionAssignment_3_3_1 )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1539:2: rule__VideoDescription__DescriptionAssignment_3_3_1
            {
            pushFollow(FOLLOW_rule__VideoDescription__DescriptionAssignment_3_3_1_in_rule__VideoDescription__Group_3_3__1__Impl3022);
            rule__VideoDescription__DescriptionAssignment_3_3_1();

            state._fsp--;


            }

             after(grammarAccess.getVideoDescriptionAccess().getDescriptionAssignment_3_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__Group_3_3__1__Impl"


    // $ANTLR start "rule__VideoGeneratorModel__InformationAssignment_1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1554:1: rule__VideoGeneratorModel__InformationAssignment_1 : ( ruleVideoGenInformation ) ;
    public final void rule__VideoGeneratorModel__InformationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1558:1: ( ( ruleVideoGenInformation ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1559:1: ( ruleVideoGenInformation )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1559:1: ( ruleVideoGenInformation )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1560:1: ruleVideoGenInformation
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getInformationVideoGenInformationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVideoGenInformation_in_rule__VideoGeneratorModel__InformationAssignment_13061);
            ruleVideoGenInformation();

            state._fsp--;

             after(grammarAccess.getVideoGeneratorModelAccess().getInformationVideoGenInformationParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__InformationAssignment_1"


    // $ANTLR start "rule__VideoGeneratorModel__VideoseqsAssignment_4"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1569:1: rule__VideoGeneratorModel__VideoseqsAssignment_4 : ( ruleVideoSeq ) ;
    public final void rule__VideoGeneratorModel__VideoseqsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1573:1: ( ( ruleVideoSeq ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1574:1: ( ruleVideoSeq )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1574:1: ( ruleVideoSeq )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1575:1: ruleVideoSeq
            {
             before(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsVideoSeqParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleVideoSeq_in_rule__VideoGeneratorModel__VideoseqsAssignment_43092);
            ruleVideoSeq();

            state._fsp--;

             after(grammarAccess.getVideoGeneratorModelAccess().getVideoseqsVideoSeqParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGeneratorModel__VideoseqsAssignment_4"


    // $ANTLR start "rule__VideoGenInformation__AuthorNameAssignment_1_1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1584:1: rule__VideoGenInformation__AuthorNameAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__AuthorNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1588:1: ( ( RULE_STRING ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1589:1: ( RULE_STRING )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1589:1: ( RULE_STRING )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1590:1: RULE_STRING
            {
             before(grammarAccess.getVideoGenInformationAccess().getAuthorNameSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__VideoGenInformation__AuthorNameAssignment_1_13123); 
             after(grammarAccess.getVideoGenInformationAccess().getAuthorNameSTRINGTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__AuthorNameAssignment_1_1"


    // $ANTLR start "rule__VideoGenInformation__VersionAssignment_2_1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1599:1: rule__VideoGenInformation__VersionAssignment_2_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__VersionAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1603:1: ( ( RULE_STRING ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1604:1: ( RULE_STRING )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1604:1: ( RULE_STRING )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1605:1: RULE_STRING
            {
             before(grammarAccess.getVideoGenInformationAccess().getVersionSTRINGTerminalRuleCall_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__VideoGenInformation__VersionAssignment_2_13154); 
             after(grammarAccess.getVideoGenInformationAccess().getVersionSTRINGTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__VersionAssignment_2_1"


    // $ANTLR start "rule__VideoGenInformation__CreationDateAssignment_3_1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1614:1: rule__VideoGenInformation__CreationDateAssignment_3_1 : ( RULE_STRING ) ;
    public final void rule__VideoGenInformation__CreationDateAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1618:1: ( ( RULE_STRING ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1619:1: ( RULE_STRING )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1619:1: ( RULE_STRING )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1620:1: RULE_STRING
            {
             before(grammarAccess.getVideoGenInformationAccess().getCreationDateSTRINGTerminalRuleCall_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__VideoGenInformation__CreationDateAssignment_3_13185); 
             after(grammarAccess.getVideoGenInformationAccess().getCreationDateSTRINGTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoGenInformation__CreationDateAssignment_3_1"


    // $ANTLR start "rule__MandatoryVideoSeq__DescriptionAssignment_1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1629:1: rule__MandatoryVideoSeq__DescriptionAssignment_1 : ( ruleVideoDescription ) ;
    public final void rule__MandatoryVideoSeq__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1633:1: ( ( ruleVideoDescription ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1634:1: ( ruleVideoDescription )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1634:1: ( ruleVideoDescription )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1635:1: ruleVideoDescription
            {
             before(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVideoDescription_in_rule__MandatoryVideoSeq__DescriptionAssignment_13216);
            ruleVideoDescription();

            state._fsp--;

             after(grammarAccess.getMandatoryVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MandatoryVideoSeq__DescriptionAssignment_1"


    // $ANTLR start "rule__OptionalVideoSeq__DescriptionAssignment_1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1644:1: rule__OptionalVideoSeq__DescriptionAssignment_1 : ( ruleVideoDescription ) ;
    public final void rule__OptionalVideoSeq__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1648:1: ( ( ruleVideoDescription ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1649:1: ( ruleVideoDescription )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1649:1: ( ruleVideoDescription )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1650:1: ruleVideoDescription
            {
             before(grammarAccess.getOptionalVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVideoDescription_in_rule__OptionalVideoSeq__DescriptionAssignment_13247);
            ruleVideoDescription();

            state._fsp--;

             after(grammarAccess.getOptionalVideoSeqAccess().getDescriptionVideoDescriptionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OptionalVideoSeq__DescriptionAssignment_1"


    // $ANTLR start "rule__AlternativeVideoSeq__VideoidAssignment_1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1659:1: rule__AlternativeVideoSeq__VideoidAssignment_1 : ( RULE_ID ) ;
    public final void rule__AlternativeVideoSeq__VideoidAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1663:1: ( ( RULE_ID ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1664:1: ( RULE_ID )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1664:1: ( RULE_ID )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1665:1: RULE_ID
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideoidIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AlternativeVideoSeq__VideoidAssignment_13278); 
             after(grammarAccess.getAlternativeVideoSeqAccess().getVideoidIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__VideoidAssignment_1"


    // $ANTLR start "rule__AlternativeVideoSeq__VideodescsAssignment_3"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1674:1: rule__AlternativeVideoSeq__VideodescsAssignment_3 : ( ruleVideoDescription ) ;
    public final void rule__AlternativeVideoSeq__VideodescsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1678:1: ( ( ruleVideoDescription ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1679:1: ( ruleVideoDescription )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1679:1: ( ruleVideoDescription )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1680:1: ruleVideoDescription
            {
             before(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsVideoDescriptionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleVideoDescription_in_rule__AlternativeVideoSeq__VideodescsAssignment_33309);
            ruleVideoDescription();

            state._fsp--;

             after(grammarAccess.getAlternativeVideoSeqAccess().getVideodescsVideoDescriptionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeVideoSeq__VideodescsAssignment_3"


    // $ANTLR start "rule__VideoDescription__VideoidAssignment_1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1689:1: rule__VideoDescription__VideoidAssignment_1 : ( RULE_ID ) ;
    public final void rule__VideoDescription__VideoidAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1693:1: ( ( RULE_ID ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1694:1: ( RULE_ID )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1694:1: ( RULE_ID )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1695:1: RULE_ID
            {
             before(grammarAccess.getVideoDescriptionAccess().getVideoidIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VideoDescription__VideoidAssignment_13340); 
             after(grammarAccess.getVideoDescriptionAccess().getVideoidIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__VideoidAssignment_1"


    // $ANTLR start "rule__VideoDescription__LocationAssignment_2"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1704:1: rule__VideoDescription__LocationAssignment_2 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__LocationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1708:1: ( ( RULE_STRING ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1709:1: ( RULE_STRING )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1709:1: ( RULE_STRING )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1710:1: RULE_STRING
            {
             before(grammarAccess.getVideoDescriptionAccess().getLocationSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__VideoDescription__LocationAssignment_23371); 
             after(grammarAccess.getVideoDescriptionAccess().getLocationSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__LocationAssignment_2"


    // $ANTLR start "rule__VideoDescription__DurationAssignment_3_1_1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1719:1: rule__VideoDescription__DurationAssignment_3_1_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__DurationAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1723:1: ( ( RULE_INT ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1724:1: ( RULE_INT )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1724:1: ( RULE_INT )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1725:1: RULE_INT
            {
             before(grammarAccess.getVideoDescriptionAccess().getDurationINTTerminalRuleCall_3_1_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__VideoDescription__DurationAssignment_3_1_13402); 
             after(grammarAccess.getVideoDescriptionAccess().getDurationINTTerminalRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__DurationAssignment_3_1_1"


    // $ANTLR start "rule__VideoDescription__ProbabilityAssignment_3_2_1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1734:1: rule__VideoDescription__ProbabilityAssignment_3_2_1 : ( RULE_INT ) ;
    public final void rule__VideoDescription__ProbabilityAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1738:1: ( ( RULE_INT ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1739:1: ( RULE_INT )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1739:1: ( RULE_INT )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1740:1: RULE_INT
            {
             before(grammarAccess.getVideoDescriptionAccess().getProbabilityINTTerminalRuleCall_3_2_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__VideoDescription__ProbabilityAssignment_3_2_13433); 
             after(grammarAccess.getVideoDescriptionAccess().getProbabilityINTTerminalRuleCall_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__ProbabilityAssignment_3_2_1"


    // $ANTLR start "rule__VideoDescription__DescriptionAssignment_3_3_1"
    // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1749:1: rule__VideoDescription__DescriptionAssignment_3_3_1 : ( RULE_STRING ) ;
    public final void rule__VideoDescription__DescriptionAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1753:1: ( ( RULE_STRING ) )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1754:1: ( RULE_STRING )
            {
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1754:1: ( RULE_STRING )
            // ../org.xtext.example.videogenerator.ui/src-gen/org/xtext/example/mydsl/ui/contentassist/antlr/internal/InternalVideoGen.g:1755:1: RULE_STRING
            {
             before(grammarAccess.getVideoDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_3_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__VideoDescription__DescriptionAssignment_3_3_13464); 
             after(grammarAccess.getVideoDescriptionAccess().getDescriptionSTRINGTerminalRuleCall_3_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VideoDescription__DescriptionAssignment_3_3_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleVideoGeneratorModel_in_entryRuleVideoGeneratorModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVideoGeneratorModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__0_in_ruleVideoGeneratorModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoGenInformation_in_entryRuleVideoGenInformation121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVideoGenInformation128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group__0_in_ruleVideoGenInformation154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoSeq_in_entryRuleVideoSeq181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVideoSeq188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoSeq__Alternatives_in_ruleVideoSeq214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMandatoryVideoSeq_in_entryRuleMandatoryVideoSeq241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMandatoryVideoSeq248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MandatoryVideoSeq__Group__0_in_ruleMandatoryVideoSeq274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptionalVideoSeq_in_entryRuleOptionalVideoSeq301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptionalVideoSeq308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OptionalVideoSeq__Group__0_in_ruleOptionalVideoSeq334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternativeVideoSeq_in_entryRuleAlternativeVideoSeq361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeVideoSeq368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__Group__0_in_ruleAlternativeVideoSeq394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoDescription_in_entryRuleVideoDescription421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVideoDescription428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group__0_in_ruleVideoDescription454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMandatoryVideoSeq_in_rule__VideoSeq__Alternatives490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptionalVideoSeq_in_rule__VideoSeq__Alternatives507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternativeVideoSeq_in_rule__VideoSeq__Alternatives524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__0__Impl_in_rule__VideoGeneratorModel__Group__0554 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__1_in_rule__VideoGeneratorModel__Group__0557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__1__Impl_in_rule__VideoGeneratorModel__Group__1615 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__2_in_rule__VideoGeneratorModel__Group__1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__InformationAssignment_1_in_rule__VideoGeneratorModel__Group__1__Impl645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__2__Impl_in_rule__VideoGeneratorModel__Group__2675 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__3_in_rule__VideoGeneratorModel__Group__2678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__VideoGeneratorModel__Group__2__Impl706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__3__Impl_in_rule__VideoGeneratorModel__Group__3737 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__4_in_rule__VideoGeneratorModel__Group__3740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LEFT_BRACKET_in_rule__VideoGeneratorModel__Group__3__Impl767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__4__Impl_in_rule__VideoGeneratorModel__Group__4796 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__5_in_rule__VideoGeneratorModel__Group__4799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__VideoseqsAssignment_4_in_rule__VideoGeneratorModel__Group__4__Impl828 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__VideoseqsAssignment_4_in_rule__VideoGeneratorModel__Group__4__Impl840 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_rule__VideoGeneratorModel__Group__5__Impl_in_rule__VideoGeneratorModel__Group__5873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RIGHT_BRACKET_in_rule__VideoGeneratorModel__Group__5__Impl900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group__0__Impl_in_rule__VideoGenInformation__Group__0941 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group__1_in_rule__VideoGenInformation__Group__0944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group__1__Impl_in_rule__VideoGenInformation__Group__11002 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group__2_in_rule__VideoGenInformation__Group__11005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_1__0_in_rule__VideoGenInformation__Group__1__Impl1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group__2__Impl_in_rule__VideoGenInformation__Group__21063 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group__3_in_rule__VideoGenInformation__Group__21066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_2__0_in_rule__VideoGenInformation__Group__2__Impl1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group__3__Impl_in_rule__VideoGenInformation__Group__31124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_3__0_in_rule__VideoGenInformation__Group__3__Impl1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_1__0__Impl_in_rule__VideoGenInformation__Group_1__01190 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_1__1_in_rule__VideoGenInformation__Group_1__01193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__VideoGenInformation__Group_1__0__Impl1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_1__1__Impl_in_rule__VideoGenInformation__Group_1__11252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__AuthorNameAssignment_1_1_in_rule__VideoGenInformation__Group_1__1__Impl1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_2__0__Impl_in_rule__VideoGenInformation__Group_2__01313 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_2__1_in_rule__VideoGenInformation__Group_2__01316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__VideoGenInformation__Group_2__0__Impl1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_2__1__Impl_in_rule__VideoGenInformation__Group_2__11375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__VersionAssignment_2_1_in_rule__VideoGenInformation__Group_2__1__Impl1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_3__0__Impl_in_rule__VideoGenInformation__Group_3__01436 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_3__1_in_rule__VideoGenInformation__Group_3__01439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__VideoGenInformation__Group_3__0__Impl1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__Group_3__1__Impl_in_rule__VideoGenInformation__Group_3__11498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoGenInformation__CreationDateAssignment_3_1_in_rule__VideoGenInformation__Group_3__1__Impl1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MandatoryVideoSeq__Group__0__Impl_in_rule__MandatoryVideoSeq__Group__01559 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__MandatoryVideoSeq__Group__1_in_rule__MandatoryVideoSeq__Group__01562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__MandatoryVideoSeq__Group__0__Impl1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MandatoryVideoSeq__Group__1__Impl_in_rule__MandatoryVideoSeq__Group__11621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MandatoryVideoSeq__DescriptionAssignment_1_in_rule__MandatoryVideoSeq__Group__1__Impl1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OptionalVideoSeq__Group__0__Impl_in_rule__OptionalVideoSeq__Group__01682 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__OptionalVideoSeq__Group__1_in_rule__OptionalVideoSeq__Group__01685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__OptionalVideoSeq__Group__0__Impl1713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OptionalVideoSeq__Group__1__Impl_in_rule__OptionalVideoSeq__Group__11744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OptionalVideoSeq__DescriptionAssignment_1_in_rule__OptionalVideoSeq__Group__1__Impl1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__Group__0__Impl_in_rule__AlternativeVideoSeq__Group__01805 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__Group__1_in_rule__AlternativeVideoSeq__Group__01808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AlternativeVideoSeq__Group__0__Impl1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__Group__1__Impl_in_rule__AlternativeVideoSeq__Group__11867 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__Group__2_in_rule__AlternativeVideoSeq__Group__11870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__VideoidAssignment_1_in_rule__AlternativeVideoSeq__Group__1__Impl1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__Group__2__Impl_in_rule__AlternativeVideoSeq__Group__21928 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__Group__3_in_rule__AlternativeVideoSeq__Group__21931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LEFT_BRACKET_in_rule__AlternativeVideoSeq__Group__2__Impl1958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__Group__3__Impl_in_rule__AlternativeVideoSeq__Group__31987 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__Group__4_in_rule__AlternativeVideoSeq__Group__31990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__VideodescsAssignment_3_in_rule__AlternativeVideoSeq__Group__3__Impl2019 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__VideodescsAssignment_3_in_rule__AlternativeVideoSeq__Group__3__Impl2031 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__AlternativeVideoSeq__Group__4__Impl_in_rule__AlternativeVideoSeq__Group__42064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RIGHT_BRACKET_in_rule__AlternativeVideoSeq__Group__4__Impl2091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group__0__Impl_in_rule__VideoDescription__Group__02130 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group__1_in_rule__VideoDescription__Group__02133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__VideoDescription__Group__0__Impl2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group__1__Impl_in_rule__VideoDescription__Group__12192 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group__2_in_rule__VideoDescription__Group__12195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__VideoidAssignment_1_in_rule__VideoDescription__Group__1__Impl2222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group__2__Impl_in_rule__VideoDescription__Group__22253 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group__3_in_rule__VideoDescription__Group__22256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__LocationAssignment_2_in_rule__VideoDescription__Group__2__Impl2283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group__3__Impl_in_rule__VideoDescription__Group__32313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3__0_in_rule__VideoDescription__Group__3__Impl2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3__0__Impl_in_rule__VideoDescription__Group_3__02379 = new BitSet(new long[]{0x0000000000E00020L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3__1_in_rule__VideoDescription__Group_3__02382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LEFT_BRACKET_in_rule__VideoDescription__Group_3__0__Impl2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3__1__Impl_in_rule__VideoDescription__Group_3__12438 = new BitSet(new long[]{0x0000000000E00020L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3__2_in_rule__VideoDescription__Group_3__12441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_1__0_in_rule__VideoDescription__Group_3__1__Impl2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3__2__Impl_in_rule__VideoDescription__Group_3__22499 = new BitSet(new long[]{0x0000000000E00020L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3__3_in_rule__VideoDescription__Group_3__22502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_2__0_in_rule__VideoDescription__Group_3__2__Impl2529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3__3__Impl_in_rule__VideoDescription__Group_3__32560 = new BitSet(new long[]{0x0000000000E00020L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3__4_in_rule__VideoDescription__Group_3__32563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_3__0_in_rule__VideoDescription__Group_3__3__Impl2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3__4__Impl_in_rule__VideoDescription__Group_3__42621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RIGHT_BRACKET_in_rule__VideoDescription__Group_3__4__Impl2648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_1__0__Impl_in_rule__VideoDescription__Group_3_1__02687 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_1__1_in_rule__VideoDescription__Group_3_1__02690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__VideoDescription__Group_3_1__0__Impl2718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_1__1__Impl_in_rule__VideoDescription__Group_3_1__12749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__DurationAssignment_3_1_1_in_rule__VideoDescription__Group_3_1__1__Impl2776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_2__0__Impl_in_rule__VideoDescription__Group_3_2__02810 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_2__1_in_rule__VideoDescription__Group_3_2__02813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__VideoDescription__Group_3_2__0__Impl2841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_2__1__Impl_in_rule__VideoDescription__Group_3_2__12872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__ProbabilityAssignment_3_2_1_in_rule__VideoDescription__Group_3_2__1__Impl2899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_3__0__Impl_in_rule__VideoDescription__Group_3_3__02933 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_3__1_in_rule__VideoDescription__Group_3_3__02936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__VideoDescription__Group_3_3__0__Impl2964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__Group_3_3__1__Impl_in_rule__VideoDescription__Group_3_3__12995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VideoDescription__DescriptionAssignment_3_3_1_in_rule__VideoDescription__Group_3_3__1__Impl3022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoGenInformation_in_rule__VideoGeneratorModel__InformationAssignment_13061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoSeq_in_rule__VideoGeneratorModel__VideoseqsAssignment_43092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__VideoGenInformation__AuthorNameAssignment_1_13123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__VideoGenInformation__VersionAssignment_2_13154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__VideoGenInformation__CreationDateAssignment_3_13185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoDescription_in_rule__MandatoryVideoSeq__DescriptionAssignment_13216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoDescription_in_rule__OptionalVideoSeq__DescriptionAssignment_13247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AlternativeVideoSeq__VideoidAssignment_13278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVideoDescription_in_rule__AlternativeVideoSeq__VideodescsAssignment_33309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VideoDescription__VideoidAssignment_13340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__VideoDescription__LocationAssignment_23371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__VideoDescription__DurationAssignment_3_1_13402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__VideoDescription__ProbabilityAssignment_3_2_13433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__VideoDescription__DescriptionAssignment_3_3_13464 = new BitSet(new long[]{0x0000000000000002L});

}